package com.example.backend_as_frontend.service;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class ProcurementNatureService {



    private final WebClient webClient;

    private final String baseURI = "http://localhost:1010/v1/procurement_nature";


    public ProcurementNatureService(WebClient webClient) {
        this.webClient = webClient;
    }

    public void  get(){

        webClient.get()
                .uri(baseURI);
    }


    public void  getAll(){

    }


    public void  save(){

    }


    public void  update(){

    }


    public void  delete(){

    }

}
