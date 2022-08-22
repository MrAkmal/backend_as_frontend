package com.example.backend_as_frontend.controller;

import com.example.backend_as_frontend.service.FinancialYearService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/financial-year")
public class FinancialYearController {


    private final FinancialYearService service;

    @Autowired
    public FinancialYearController(FinancialYearService service) {
        this.service = service;
    }


    @GetMapping
    public String getFinancialYearPage() {
        return "financial-year";
    }
}
