package it.academy.controller;

import it.academy.service.BrandModelService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AddBrandController {

    @Autowired
    BrandModelService brandModelService;

    @GetMapping("/add-brand.view")
    public String showAddBrandModelPage() {
        return "/add_brand";
    }

    @PostMapping("/add-brand.action")
    @SneakyThrows
    public String addBrandModel(String brandName) {
        brandModelService.createBrand(brandName);
        return "redirect:/add-brand.view";
    }
}
