package org.example.coreservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Response {

    private String responseCode;
    private String responseMessage;
    private String transactionId;
    private String journal;
    private double chargeAmount;
}

