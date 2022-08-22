package com.example.backend_as_frontend.service;

import com.example.backend_as_frontend.entity.ProcurementMethod;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class ProcurementMethodService {



    private final WebClient webClient;

    private final String baseURI = "http://localhost:2020/v1/procurement_method";


    public ProcurementMethodService(WebClient webClient) {
        this.webClient = webClient;
    }

    public ProcurementMethod get(Integer id) {

        Mono<ProcurementMethod> entity = webClient.get()
                .uri(baseURI + "/" + id)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .retrieve()
                .bodyToMono(ProcurementMethod.class);

        return entity.block();

    }


    public List<ProcurementMethod> getAll() {

        Flux<ProcurementMethod> entity = webClient.get()
                .uri(baseURI)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .retrieve()
                .bodyToFlux(ProcurementMethod.class);

        return entity.collectList().block();
    }


    public void save(ProcurementMethod nature) {


        Mono<ProcurementMethod> entity = webClient.post()
                .uri(baseURI)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .body(Mono.just(nature), ProcurementMethod.class)
                .retrieve()
                .bodyToMono(ProcurementMethod.class);

        System.out.println("entity.block() = " + entity.block());


    }


    public void update(ProcurementMethod nature) {


        Mono<ProcurementMethod> entity = webClient.put()
                .uri(baseURI)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .body(Mono.just(nature), ProcurementMethod.class)
                .retrieve()
                .bodyToMono(ProcurementMethod.class);

        System.out.println("entity.block() = " + entity.block());


    }


    public void delete(Integer id) {

        Mono<ProcurementMethod> entity = webClient.delete()
                .uri(baseURI + "/" + id)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .retrieve()
                .bodyToMono(ProcurementMethod.class);


        System.out.println("entity.block() = " + entity.block());

    }
}
