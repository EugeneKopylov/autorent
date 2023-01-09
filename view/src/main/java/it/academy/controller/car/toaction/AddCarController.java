package it.academy.controller.car.toaction;

import it.academy.api.dto.car.CarCreationDto;
import it.academy.api.mapper.Mapper;
import it.academy.service.car.CarService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class AddCarController {

    @Autowired
    CarService carService;

    @Autowired
    Mapper mapper;

    @GetMapping("/add-car.view")
    public String showAddCarPage(){
        return "add_car";
    }

    @PostMapping("add-car.action")
    @SneakyThrows
    public String addCar(@RequestParam("picture") MultipartFile file, CarCreationDto carDto) {
        carService.addNewCar(mapper.toCar(carDto), file.getBytes());
        return "redirect:/car-list/0.view";
    }
}
