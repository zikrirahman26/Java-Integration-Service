package org.example.integrationapp.service;

import org.example.integrationapp.model.ErrorResponse;
import org.example.integrationapp.model.ChannelRequest;
import org.example.integrationapp.model.ChannelResponse;
import org.example.integrationapp.model.ContentResponse;
import org.example.integrationapp.model.SubmitCoreResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {

    private final SubmitCoreService submitCoreService;

    @Autowired
    public TransactionService(SubmitCoreService submitCoreService) {
        this.submitCoreService = submitCoreService;
    }

    public Object request(ChannelRequest channelRequest) {
        SubmitCoreResponse submitCoreResponse = submitCoreService.submitCoreResponse(channelRequest);

        double totalAmount = channelRequest.getContentRequest().getAmount() + submitCoreResponse.getChargeAmount();

        if ("00".equals(submitCoreResponse.getResponseCode())) {

            return ChannelResponse.builder()
                    .clientId(channelRequest.getClientId())
                    .reffNum(channelRequest.getReffNum())
                    .journal(submitCoreResponse.getJournal())
                    .financialJournal(submitCoreResponse.getTransactionId())
                    .contentResponse(
                            ContentResponse.builder()
                                    .providerId(channelRequest.getContentRequest().getProviderId())
                                    .cardNum(channelRequest.getContentRequest().getCardNum())
                                    .accountNum(channelRequest.getContentRequest().getAccountNum())
                                    .amount(channelRequest.getContentRequest().getAmount())
                                    .chargeAmount(submitCoreResponse.getChargeAmount())
                                    .totalAmount(totalAmount)
                                    .build()
                    )
                    .build();

        } else {

            return new ErrorResponse(submitCoreResponse.getResponseCode(), submitCoreResponse.getResponseMessage());
        }
    }
}
