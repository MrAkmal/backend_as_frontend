package com.example.backend_as_frontend.service;

import com.example.backend_as_frontend.entity.FinancialYear;
import com.example.backend_as_frontend.entity.PaymentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

import static com.example.backend_as_frontend.utils.Utils.getToken;
import static org.springframework.http.HttpHeaders.AUTHORIZATION;

@Service
public class PaymentTypeService {

    private final WebClient webClient;

    private final String baseURI = "http://localhost:9595/v1/payment/payment_type";

    @Autowired
    public PaymentTypeService(WebClient webClient) {
        this.webClient = webClient;
    }

    public List<PaymentType> getAll() {
        Mono<List<PaymentType>> entity = webClient.get()
                .uri(baseURI)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .header(AUTHORIZATION, getToken())
                .retrieve()
                .bodyToFlux(PaymentType.class)
                .collectList();

        List<PaymentType> block = entity.block();
        return block;
    }
}
