package org.example.integrationapp.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SubmitCoreResponse {

    private String responseCode;
    private String responseMessage;
    private String transactionId;
    private String journal;
    private double chargeAmount;
}
