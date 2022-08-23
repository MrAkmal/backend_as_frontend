package com.example.backend_as_frontend.controller;

import com.example.backend_as_frontend.entity.FinancialYear;
import com.example.backend_as_frontend.entity.FinancialYearCreateDTO;
import com.example.backend_as_frontend.service.FinancialYearService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/financial-year")
public class FinancialYearController {


    private final FinancialYearService service;

    @Autowired
    public FinancialYearController(FinancialYearService service) {
        this.service = service;
    }


    @GetMapping
    public String getListPage(Model model) {
        model.addAttribute("financialYears", service.getAll());
        return "financial-year";
    }

    @GetMapping("/{id}")
    public FinancialYearCreateDTO get(@PathVariable Integer id) {
        return service.get(id);
    }

    @GetMapping("/create")
    public String getCreatePage(Model model) {
        model.addAttribute("financialYear", new FinancialYearCreateDTO());
        return "financial-year-form";
    }

    @GetMapping("/update/{id}")
    public String getUpdatePage(Model model, @PathVariable Integer id) {
        FinancialYearCreateDTO financialYear = service.get(id);
        model.addAttribute("financialYear", financialYear);
        return "financial-year-form";
    }

    @PostMapping
    public String save(FinancialYearCreateDTO dto) {
        System.out.println("financialYear.getId() = " + dto.getId());
        if (dto.getId() != 0) {
            service.update(dto);
        } else {
            service.save(dto);
        }
        return "redirect:/financial-year";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        service.delete(id);
        return "redirect:/financial-year";
    }
}
