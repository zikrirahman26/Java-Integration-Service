package org.example.coreservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CoreRequest {

    private String cardNumber;
    private String transactionId;
    private double amount;
    private String dateTimePayment;
    private String providerId;
}

