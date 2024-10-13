package org.example.coreservice.service;

import org.example.coreservice.model.Request;
import org.example.coreservice.model.Response;
import org.example.coreservice.utils.GenerateJournal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CoreService {

    private final GenerateJournal generateJournal;

    @Autowired
    public CoreService(GenerateJournal generateJournal){
        this.generateJournal = generateJournal;
    }

    public Response processPayment(Request request) {
        double chargeAmount = 1500;
        String journal = generateJournal.generateJournal();

        if (request.getAmount() < 10000) {
            return Response.builder()
                    .responseCode("99")
                    .responseMessage("Rejected")
                    .transactionId(request.getTransactionId())
                    .build();
        } else {
            return Response.builder()
                    .responseCode("00")
                    .responseMessage("Successful")
                    .transactionId(request.getTransactionId())
                    .journal(journal)
                    .chargeAmount(chargeAmount)
                    .build();
        }
    }
}

