package com.example.backend_as_frontend.controller;

import com.example.backend_as_frontend.service.ProcurementNatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class ProcurementNatureController {


    private final ProcurementNatureService service;

    @Autowired
    public ProcurementNatureController(ProcurementNatureService service) {
        this.service = service;
    }



}
