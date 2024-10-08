package org.example.coreservice.repository;

import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class GenerateJournal {

    public String generateJornal() {
        String uuid = UUID.randomUUID().toString();
        String numericOnly = uuid.replaceAll("[^0-9]", "");

        return numericOnly.substring(0, 8);
    }
}
