package it.academy.controller.car.toaction;

import it.academy.service.car.CarService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Secured(value = {"ROLE_ADMIN"})
@Controller
public class DeleteCarController {

    @Autowired
    CarService carService;

    @PostMapping("delete-car/{brand}/{model}/{price}.action")
    @SneakyThrows
    public String deleteCar(@PathVariable String brand,
                            @PathVariable String model,
                            @PathVariable Integer price) {
        carService.deleteCarByBrandModelCost(price,brand,model);
        return "redirect:/car-list/0.view";
    }
}
