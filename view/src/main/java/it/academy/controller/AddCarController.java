package it.academy.controller;

import it.academy.model.Car;
import it.academy.service.CarService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class AddCarController {

    @Autowired
    CarService carService;

    @GetMapping("/add-car.view")
    public String showAddCarPage(){
        return "add_car";
    }

    @PostMapping("/add-car.action")
    @SneakyThrows
    public String addCar(@RequestParam("picture") MultipartFile file, Car car) {
        byte[] bytes = file.getBytes();
        carService.addNewCar(car, bytes);
        return "redirect:/car-list/0.view";
    }
}
