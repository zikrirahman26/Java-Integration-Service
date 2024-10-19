package org.example.coreservice.service;

import org.example.coreservice.model.CoreRequest;
import org.example.coreservice.model.CoreResponse;
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

    public CoreResponse processPayment(CoreRequest coreRequest) {
        double chargeAmount = 1500;
        String journal = generateJournal.generateJournal();
        if (coreRequest.getAmount() < 10000) {
            return CoreResponse.builder()
                    .responseCode("99")
                    .responseMessage("Rejected")
                    .transactionId(coreRequest.getTransactionId())
                    .build();
        } else {
            return CoreResponse.builder()
                    .responseCode("00")
                    .responseMessage("Successful")
                    .transactionId(coreRequest.getTransactionId())
                    .journal(journal)
                    .chargeAmount(chargeAmount)
                    .build();
        }
    }
}

