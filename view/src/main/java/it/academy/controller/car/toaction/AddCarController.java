package it.academy.controller.car.toaction;

import it.academy.api.dto.car.BrandModelDto;
import it.academy.api.dto.car.CarCreationDto;
import it.academy.api.mapper.BrandModelMapper;
import it.academy.api.mapper.Mapper;
import it.academy.model.car.CarBrand;
import it.academy.model.car.CarModel;
import it.academy.service.car.BrandModelService;
import it.academy.service.car.CarService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.xml.bind.Element;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.toList;

@Scope("session")
@SessionAttributes("branded")
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

        List<String> brandNames = brandModelService.getAllBrandStringName();
        CarBrand carBrand = brandModelService.getCarBrandByBrandName(brand).get(0);
        brandModelService.getAllModelStringFromBrand(carBrand);

        List<String> modelNames = brandModelService.getAllModelStringFromBrand(carBrand);

        model.addAttribute("brand", brandNames);
        model.addAttribute("branded", brand);
        model.addAttribute("models", modelNames);

        return new ModelAndView("add_car");
    }
}
