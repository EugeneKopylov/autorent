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

    @GetMapping("/add-car.html")
    public String showAddCarPage(){
        return "add_car";
    }

    @PostMapping("/add-car.html")
    @SneakyThrows
    public String addCar(@RequestParam("picture") MultipartFile file, Car car) {
        //System.out.println(file.getOriginalFilename() + ": " + file.getSize());
        System.out.println("_____________________________________________________________________________________");
        byte[] bytes = file.getBytes();
        System.out.println(bytes);
        //System.out.println(Arrays.toString(file.getBytes()));
        System.out.println("_____________________________________________________________________________________");
        carService.addNewCar(car, bytes);
        return "redirect:/car-list/0.html";
    }
}
