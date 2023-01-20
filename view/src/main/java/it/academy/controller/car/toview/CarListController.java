package it.academy.controller.car.toview;

import it.academy.api.mapper.Mapper;
import it.academy.service.car.CarService;
import it.academy.service.car.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

import static java.util.stream.Collectors.toList;

@Controller
public class CarListController {

    @Autowired
    CarService carService;

    @Autowired
    PictureService pictureService;

    @Autowired
    Mapper mapper;

    private static final int PAGE_SIZE = 2;

    //тут уже будет carDto?
    @GetMapping("/car-list/0.view")
    public ModelAndView showCarList() {
        return new ModelAndView(
                "car_list",
                Map.of("cars", carService.listOfCarsWithPagination(0, PAGE_SIZE).stream().map(mapper::toDto).collect(toList()))
        );
    }

    @GetMapping("car-list/{offset}.view")
    public ModelAndView getCarsWithPagination(@PathVariable int offset) {
        return new ModelAndView(
                "car_list",
                Map.of("cars", carService.listOfCarsWithPagination(offset, PAGE_SIZE).stream().map(mapper::toDto).collect(toList()))
        );
    }

    @ResponseBody
    @GetMapping("/image/{car.carIdPicture}/picture.jpg")
    public byte[] getImage(@PathVariable("car.carIdPicture") int carIdPicture) {
        return pictureService.getCarPictureById(carIdPicture).getPicture();
    }

}
