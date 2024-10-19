package org.example.integrationapp.controller;

import org.example.integrationapp.model.ErrorResponse;
import org.example.integrationapp.model.ChannelRequest;
import org.example.integrationapp.service.TransactionService;
import org.example.integrationapp.service.ValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/rest/api/channel")
public class TransactionController {

    private final TransactionService transactionService;
    private final ValidationService validationService;

    @Autowired
    public TransactionController(TransactionService transactionService,
                                 ValidationService validationService) {
        this.transactionService = transactionService;
        this.validationService = validationService;
    }

    @PostMapping("/transaction")
    public ResponseEntity<?> processPayment(@RequestBody ChannelRequest channelRequest) {
        try {
            validationService.validateRequest(channelRequest);

            Object response = transactionService.request(channelRequest);

            if (response instanceof ErrorResponse errorResponse) {
                return ResponseEntity.badRequest().body(errorResponse);
            } else {

                return ResponseEntity.ok(response);
            }
        } catch (ResponseStatusException e) {
            ErrorResponse errorResponse = ErrorResponse.builder()
                    .errorCode(String.valueOf(e.getStatusCode().value()))
                    .errorMessage(e.getReason())
                    .build();

            return ResponseEntity.status(e.getStatusCode()).body(errorResponse);
        }
    }
}
