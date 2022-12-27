package it.academy.controller.car.toaction;

import it.academy.model.car.Car;
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

/*@RestController
public class AddCarController {

    @Autowired
    private CarService carService;

    @Autowired
    private Mapper mapper;

    public AddCarController(CarService carService, Mapper mapper) {
        this.carService = carService;
        this.mapper = mapper;
    }

    @GetMapping("/add-car.view")
    @ResponseBody
    public List<CarDto> showAddCarPage() {
    }
}*/
