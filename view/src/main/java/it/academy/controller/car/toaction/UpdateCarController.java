package it.academy.controller.car.toaction;

import it.academy.model.car.Car;
import it.academy.service.car.BrandModelService;
import it.academy.service.car.CarService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Secured(value = {"ROLE_ADMIN"})
@Controller
public class UpdateCarController {

    @Autowired
    CarService carService;

    @Autowired
    BrandModelService brandModelService;

    @GetMapping("update-car/{brand}/{model}/{price}.view")
    public ModelAndView updateCarPage(@PathVariable String brand,
                                      @PathVariable String model,
                                      @PathVariable Integer price,
                                      Model models){
        models.addAttribute("car", carService.findCarByBrandModelCost(price, brand, model));
        models.addAttribute("models", brandModelService.getCarBrandByBrandName(brand).get(0).getCarModels());
        models.addAttribute("brand", brand);
        models.addAttribute("price", price);

        return new ModelAndView("update_car");
    }

    @PostMapping("update-car/{oldBrand}/{oldModel}/{oldPrice}.action")
    @SneakyThrows
    public String updateCarAction(@PathVariable String oldBrand,
                                  @PathVariable String oldModel,
                                  @PathVariable String oldPrice,
                                  @RequestParam String bodyType,
                                  @RequestParam String models,
                                  @RequestParam String gearbox,
                                  @RequestParam String yearOfProd,
                                  @RequestParam String fuelType,
                                  @RequestParam String engineCapacity,
                                  @RequestParam String cost,
                                  @RequestParam String carDescription){
        Car car = carService.findCarByBrandModelCost(Integer.valueOf(oldPrice), oldBrand, oldModel);
        car.setCarModel(brandModelService.getCarModelName(models).get(0));
        car.setBodyType(bodyType);
        car.setGearbox(gearbox);
        car.setYearOfProd(Integer.valueOf(yearOfProd));
        car.setFuelType(fuelType);
        car.setEngineCapacity(engineCapacity);
        car.setCost(Integer.valueOf(cost));
        car.setCarDescription(carDescription);
        carService.saveCar(car);
        return "redirect:/car-list/" + oldBrand + "/" + models + "/" + cost + ".view";

    }
}
