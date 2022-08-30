package com.example.backend_as_frontend.controller;


import com.example.backend_as_frontend.dto.PaymentConfigCreateDTO;
import com.example.backend_as_frontend.service.PaymentConfigurationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/payment_config_rest")
public class PaymentConfigurationRestController {

    private final PaymentConfigurationService paymentConfigurationService;


    @Autowired
    public PaymentConfigurationRestController(PaymentConfigurationService paymentConfigurationService) {
        this.paymentConfigurationService = paymentConfigurationService;
    }

    @GetMapping
    public List<String> getAllTypes() {
        return List.of("DOCUMENT", "FEE", "REGISTER", "PE");
    }

    @PostMapping
    public ResponseEntity<Void> savePaymentConfig(@RequestBody PaymentConfigCreateDTO paymentConfig) {
        System.out.println("dto = " + paymentConfig);
        paymentConfigurationService.save(paymentConfig);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

