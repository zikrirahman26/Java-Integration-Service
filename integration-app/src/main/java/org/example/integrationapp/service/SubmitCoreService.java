package org.example.integrationapp.service;

import org.example.integrationapp.model.submitCoreDTO.SubmitCoreRequest;
import org.example.integrationapp.model.submitCoreDTO.SubmitCoreResponse;
import org.example.integrationapp.model.channelDTO.ChannelRequest;
import org.example.integrationapp.utils.FormatDateUtils;
import org.example.integrationapp.utils.GenerateTransactionId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;

@Service
public class SubmitCoreService {

    private final RestTemplate restTemplate;
    private final GenerateTransactionId generateTransactionId;

    @Value("${core.endpoint.url}")
    private String coreEndpoint;

    @Autowired
    public SubmitCoreService(RestTemplate restTemplate,
                             GenerateTransactionId generateTransactionId) {
        this.restTemplate = restTemplate;
        this.generateTransactionId = generateTransactionId;
    }

    public SubmitCoreResponse submitCoreResponse(ChannelRequest channelRequest) {
        try {
            SubmitCoreRequest submitCoreRequest = SubmitCoreRequest.builder()
                    .cardNumber(channelRequest.getContentRequest().getCardNum())
                    .transactionId(generateTransactionId.generateTransactionId())
                    .amount(channelRequest.getContentRequest().getAmount())
                    .dateTimePayment(FormatDateUtils.formatDateTime(LocalDateTime.now()))
                    .providerId(channelRequest.getContentRequest().getProviderId())
                    .build();

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);

            HttpEntity<SubmitCoreRequest> requestEntity = new HttpEntity<>(submitCoreRequest, headers);
            ResponseEntity<SubmitCoreResponse> response = restTemplate.exchange(
                    coreEndpoint,
                    HttpMethod.POST,
                    requestEntity,
                    SubmitCoreResponse.class
            );

            return response.getBody();
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
         }
    }
}
