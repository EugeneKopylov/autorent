package it.academy.controller.car.toaction;

import it.academy.dtos.dto.car.CarCreationDto;
import it.academy.dtos.mapper.BrandModelMapper;
import it.academy.dtos.mapper.Mapper;
import it.academy.model.car.CarBrand;
import it.academy.service.car.BrandModelService;
import it.academy.service.car.CarService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Scope("session")
@SessionAttributes("branded")
@Secured(value = {"ROLE_ADMIN"})
@Controller
public class AddCarController {

    @Autowired
    CarService carService;

    @Autowired
    BrandModelService brandModelService;

    @Autowired
    Mapper mapper;

    @Autowired
    BrandModelMapper brandModelMapper;

    @GetMapping("/add-car/{brand}.view")
    public ModelAndView addCarPage(Model model, @PathVariable String brand) {

        if(brand.equals("")) {
            List<String> brandNames = brandModelService.getAllBrandStringName();
            model.addAttribute("brand", brandNames);
            return new ModelAndView("add_car");
        }

        List<String> brandNames = brandModelService.getAllBrandStringName();
        CarBrand carBrand = brandModelService.getCarBrandByBrandName(brand).get(0);
        brandModelService.getAllModelStringFromBrand(carBrand);

        List<String> modelNames = brandModelService.getAllModelStringFromBrand(carBrand);

        model.addAttribute("brand", brandNames);
        model.addAttribute("branded", brand);
        model.addAttribute("models", modelNames);

        return new ModelAndView("add_car");
    }

    @PostMapping("add-car.action")
    @SneakyThrows
    public String addCar(@RequestParam("picture") MultipartFile file, CarCreationDto carDto,
                         @RequestParam("model") String models,
                         @RequestParam("brand") String brand) {
        carDto.setBrand(brand);
        carDto.setCarModel(models);
        carService.addNewCar(mapper.toCar(carDto), file.getBytes());
        return "redirect:/car-list/0.view";
    }
}
