package it.academy.controller.car.toaction;

import it.academy.model.car.CarBrand;
import it.academy.service.car.BrandModelService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
public class UpdateBrandController {

    @Autowired
    BrandModelService brandModelService;

    @GetMapping("/update-car-brand.view")
    public ModelAndView updateBrand(Model model) {
        model.addAttribute("brand", brandModelService.getAllBrandStringName());
        return new ModelAndView("update_brand");
    }

    @PostMapping("/update-car-brand/{brand}.action")
    @SneakyThrows
    public String deleteCarBrand(@RequestParam String brands,
                                 @RequestParam String newName) {
        brandModelService.updateBrandName(brands, newName);
        return "redirect:/update-car-brand.view";
    }
}