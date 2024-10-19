package org.example.integrationapp.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ChannelRequest {

    private String clientId;
    private String reffNum;
    private ContentRequest contentRequest;
}

