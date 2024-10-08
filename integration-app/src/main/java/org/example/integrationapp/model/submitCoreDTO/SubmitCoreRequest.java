package org.example.integrationapp.model.submitCoreDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SubmitCoreRequest {

    private String cardNumber;
    private String transactionId;
    private double amount;
    private String dateTimePayment;
    private String providerId;
}
