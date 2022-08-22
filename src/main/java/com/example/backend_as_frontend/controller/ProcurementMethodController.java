package com.example.backend_as_frontend.controller;

import com.example.backend_as_frontend.service.ProcurementMethodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class ProcurementMethodController {


    private final ProcurementMethodService service;


    @Autowired
    public ProcurementMethodController(ProcurementMethodService service) {
        this.service = service;
    }
}
