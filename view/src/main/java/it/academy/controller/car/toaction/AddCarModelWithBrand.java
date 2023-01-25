package it.academy.controller.car.toaction;

import it.academy.model.car.CarBrand;
import it.academy.model.car.CarModel;
import it.academy.service.car.BrandModelService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Controller
@Secured(value = {"ROLE_ADMIN"})
public class AddCarModelWithBrand {

    @Autowired
    BrandModelService brandModelService;

    @GetMapping("/add-car-model.view")
    public ModelAndView showAddCarModelPage() {
        List<CarBrand> brands = brandModelService.getAllCarBrands();
        brands.forEach(System.out::println);
        return new ModelAndView(
                "add_car_model",
                Map.of("brands", brands)
        );
    }

    @PostMapping("/add-car-model.action")
    @SneakyThrows
    public String addCarModel(CarModel carModel) {
        brandModelService.createModel(carModel);
        return "redirect:/add-car-model.view";
    }
}
