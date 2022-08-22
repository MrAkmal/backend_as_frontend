package com.example.backend_as_frontend.service;

import com.example.backend_as_frontend.entity.FinancialYear;
import com.example.backend_as_frontend.entity.ProcurementNature;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;


@Service
public class FinancialYearService {

    private final WebClient webClient;

    private final String baseURI = "http://localhost:3030/v1/financial_year";


    public FinancialYearService(WebClient webClient) {
        this.webClient = webClient;
    }

    public void get() {

    }


    public void getAll() {

        Mono<List<FinancialYear>> entity = webClient.get()
                .uri(baseURI)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .retrieve()
                .bodyToFlux(FinancialYear.class)
                .collectList();

        List<FinancialYear> block = entity.block();

    }



    public void save() {

    }


    public void update() {

    }


    public void delete() {

    }


}
