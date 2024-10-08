package org.example.integrationapp.utils;

import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class GenerateTransactionId {

    public String generateTransactionId() {
        String uuid = UUID.randomUUID().toString();
        String numericOnly = uuid.replaceAll("[^0-9]", "");

        return numericOnly.substring(0, 12);
    }
}
