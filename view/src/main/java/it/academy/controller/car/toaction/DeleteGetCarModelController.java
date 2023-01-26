package it.academy.controller.car.toaction;

import it.academy.dtos.dto.car.CarCreationDto;
import it.academy.model.car.CarBrand;
import it.academy.model.car.CarModel;
import it.academy.service.car.BrandModelService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Secured(value = {"ROLE_ADMIN"})
@Controller
public class DeleteGetCarModelController {

    @Autowired
    BrandModelService brandModelService;

    @GetMapping("/delete-car-model/{brand}.view")
    public ModelAndView deleteCarModel(Model model, @PathVariable String brand) {

        if(brand.equals("")) {
            List<String> brandNames = brandModelService.getAllBrandStringName();
            model.addAttribute("brand", brandNames);
            return new ModelAndView("delete_model");
        }

        List<String> brandNames = brandModelService.getAllBrandStringName();
        CarBrand carBrand = brandModelService.getCarBrandByBrandName(brand).get(0);
        brandModelService.getAllModelStringFromBrand(carBrand);

        List<String> modelNames = brandModelService.getAllModelStringFromBrand(carBrand);

        model.addAttribute("brand", brandNames);
        model.addAttribute("branded", brand);
        model.addAttribute("models", modelNames);

        return new ModelAndView("delete_model");
    }

    @PostMapping("delete-car-model.action")
    @SneakyThrows
    public String deleteCarModel(@RequestParam("model") String models,
                                 @RequestParam("brand") String brand) {
        brandModelService.deleteModelByModelNameBrandName(models,brand);
        return "redirect:/delete-car-model/.view";
    }

}
