package com.example.backend_as_frontend.entity;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PaymentType {


    private int id;


    private String type;


    public PaymentType(String type) {
        this.type = type;
    }

}

