package com.example.backend_as_frontend.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class PaymentBaseDTO {


    private int id;

    private String type;

    private boolean active;

    private int paymentConfigurationId;
}


