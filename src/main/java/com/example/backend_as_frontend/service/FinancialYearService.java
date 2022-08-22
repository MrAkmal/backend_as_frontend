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

    public FinancialYear get(Integer id) {

        Mono<FinancialYear> financialYearFlux = webClient.get().uri(baseURI + "/" + id)
                .retrieve().bodyToMono(FinancialYear.class);

        return financialYearFlux.block();
    }


    public List<FinancialYear> getAll() {

        Mono<List<FinancialYear>> entity = webClient.get()
                .uri(baseURI)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .retrieve()
                .bodyToFlux(FinancialYear.class)
                .collectList();

        List<FinancialYear> block = entity.block();
        return block;

    }


    public void save(FinancialYear financialYear) {

        System.out.println("financialYear = " + financialYear);

        Mono<FinancialYear> mono = webClient.post()
                .uri(baseURI)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .body(Mono.just(financialYear), FinancialYear.class)
                .retrieve()
                .bodyToMono(FinancialYear.class);

        System.out.println("mono = " + mono.block());
    }


    public void update(FinancialYear financialYear) {
        Mono<FinancialYear> mono = webClient.put()
                .uri(baseURI)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .body(Mono.just(financialYear), FinancialYear.class)
                .retrieve()
                .bodyToMono(FinancialYear.class);

        System.out.println("Update : mono.block() = " + mono.block());

    }


    public void delete(Integer id) {
        FinancialYear financialYear = get(id);

        if (financialYear != null) {

            Mono<Void> mono = webClient.delete()
                    .uri(baseURI + "/" + id)
                    .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                    .retrieve()
                    .bodyToMono(Void.class);
            System.out.println("mono = " + mono.block());
        }
    }


}
