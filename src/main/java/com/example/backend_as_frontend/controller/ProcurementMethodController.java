package com.example.backend_as_frontend.controller;

import com.example.backend_as_frontend.entity.ProcurementMethod;
import com.example.backend_as_frontend.entity.ProcurementNature;
import com.example.backend_as_frontend.service.ProcurementMethodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/procurement-method")
public class ProcurementMethodController {


    private final ProcurementMethodService service;


    @Autowired
    public ProcurementMethodController(ProcurementMethodService service) {
        this.service = service;
    }


    @GetMapping
    public String getListPage(Model model) {
        model.addAttribute("procurementMethods", service.getAll());
        return "procurement-method";
    }

    @GetMapping("/{id}")
    public ProcurementMethod get(@PathVariable Integer id) {
        return service.get(id);
    }

    @GetMapping("/create")
    public String getCreatePage(Model model) {
        model.addAttribute("procurementMethod", new ProcurementMethod());
        return "procurement-method-form";
    }

    @GetMapping("/update/{id}")
    public String getUpdatePage(Model model, @PathVariable Integer id) {
        ProcurementMethod procurementMethod = service.get(id);
        model.addAttribute("procurementMethod", procurementMethod);
        return "procurement-method-form";
    }

    @PostMapping
    public String save(ProcurementMethod procurementMethod) {
        if (procurementMethod.getId() != 0) {
            service.update(procurementMethod);
        } else {
            service.save(procurementMethod);
        }
        return "redirect:/procurement-method";
    }

    @GetMapping("/{id}")
    public String delete(@PathVariable Integer id) {
        service.delete(id);
        return "redirect:/procurement-method";
    }
}
