package com.example.backend_as_frontend.controller;

import com.example.backend_as_frontend.entity.ProcurementMethod;
import com.example.backend_as_frontend.entity.ProcurementNature;
import com.example.backend_as_frontend.service.ProcurementMethodService;
import com.example.backend_as_frontend.service.ProcurementNatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/payment-config")
public class PaymentConfigurationController {

    private final ProcurementNatureService procurementNatureService;
    private final ProcurementMethodService procurementMethodService;


    @Autowired
    public PaymentConfigurationController(ProcurementNatureService procurementNatureService, ProcurementMethodService procurementMethodService) {
        this.procurementNatureService = procurementNatureService;
        this.procurementMethodService = procurementMethodService;
    }

    @GetMapping
    public String getList() {

        return "paymentconfig/payment-config";
    }

    @GetMapping("/create")
    public String createForm(Model model) {

        List<ProcurementMethod> all = procurementMethodService.getAll();
        List<ProcurementNature> procurementNatureServiceAll = procurementNatureService.getAll();
        model.addAttribute("procurementMethods", all);
        model.addAttribute("types", List.of("DOCUMENT", "FEE", "REGISTER", "PE"));
        model.addAttribute("procurementNatures", procurementNatureServiceAll);
        return "paymentconfig/payment-config-form";
    }
}
