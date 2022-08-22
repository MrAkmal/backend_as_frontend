package com.example.backend_as_frontend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/financial-year")
public class FinancialYearController {

    @GetMapping
    public String getFinancialYearPage() {
        return "financial-year";
    }
}
