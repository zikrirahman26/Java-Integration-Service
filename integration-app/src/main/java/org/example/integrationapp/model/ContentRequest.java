package org.example.integrationapp.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ContentRequest {

    private String providerId;
    private String cardNum;
    private String accountNum;
    private double amount;
}

