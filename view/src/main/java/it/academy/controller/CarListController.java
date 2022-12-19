package it.academy.controller;

import it.academy.model.Car;
import it.academy.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
public class CarListController {

    @Autowired
    CarService carService;

    private static final int PAGE_SIZE = 2;

    @GetMapping("/car-list/0.html")
    public ModelAndView showCarList() {
        return new ModelAndView(
                "permission_list",
                Map.of("permissions", carService.listOfCars(0, PAGE_SIZE))
        );
    }

/*    @ResponseBody
    @GetMapping("/image/{car.id}/photo.jpg")
    public byte[] getImage(@PathVariable("car.id") int carId) {
        System.out.println("_________________________________________________________________________________________");
        System.out.println("Call getImage: " + carId);
        Car car = carService.getById(carId);
        return car.getCarPicture();
    }*/

}
