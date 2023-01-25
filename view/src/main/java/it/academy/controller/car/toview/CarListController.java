package it.academy.controller.car.toview;

import it.academy.dtos.dto.car.CarDto;
import it.academy.dtos.mapper.Mapper;
import it.academy.service.car.CarService;
import it.academy.service.car.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
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

    //private static final int PAGE_SIZE = 2;

/*    @GetMapping("/car-list/0.view")
    public ModelAndView showCarList() {
        return new ModelAndView(
                "car_list",
                Map.of("cars", carService.listOfCarsWithPagination(0, 2).stream().map(mapper::toDto).collect(toList()),
                        "nextPage", 1,
                        "previousPage", "0")
        );
    }*/

    ///autorent/car-list/off0pgs3.view
    @GetMapping("/car-list/off{offset}pgs{pageSize}.view")
    public ModelAndView getCarsWithPagination(@PathVariable int offset, @PathVariable int pageSize) {
        int previousPage;
        int nextPage;
        if (offset == 0) {
            previousPage = 0;
        } else {
            previousPage = offset - 1;
        }
        List<CarDto> cars = carService.listOfCarsWithPagination(offset, pageSize).stream().map(mapper::toDto).collect(toList());
        if(carService.listOfCarsWithPagination(offset + 1, pageSize).stream().map(mapper::toDto).collect(toList()).size() != 0) {
            nextPage = offset + 1;
        } else {
            nextPage = offset;
        }
        return new ModelAndView(
                "car_list",
                Map.of("cars", cars, "nextPage", nextPage, "previousPage", previousPage, "pSize", pageSize,
                        "previousPageHref", "\"/autorent/car-list/off" + previousPage + "pgs" + pageSize + ".view\"",
                        "nextPageHref", "\"/autorent/car-list/off" + nextPage + "pgs" + pageSize + ".view\"")
        );
    }

        /*@GetMapping("/car-list/{offset}{sort}.view")
    public ModelAndView getCarsWithPagination(@PathVariable int offset,
                                              @PathVariable String sort) {
        Integer nextPage;
        Integer previousPage;
        List<CarDto> cars = carService.listOfCarsWithSortingBySomethingAndPagination(
                offset, PAGE_SIZE, sort).stream().map(mapper::toDto).collect(toList());
        //List<CarDto> cars = carService.listOfCarsWithPagination(offset, PAGE_SIZE).stream().map(mapper::toDto).collect(toList());
        if(carService.listOfCarsWithPagination(offset + 1, PAGE_SIZE).stream().map(mapper::toDto).collect(toList()).size() != 0) {
            nextPage = offset + 1;
        } else {
            nextPage = offset;
        }
        previousPage = offset - 1;
        return new ModelAndView(
                "car_list",
                Map.of("cars", cars, "nextPage", nextPage, "previousPage", previousPage)
        );
    }*/

    @ResponseBody
    @GetMapping("/image/{car.carIdPicture}/picture.jpg")
    public byte[] getImage(@PathVariable("car.carIdPicture") int carIdPicture) {
        return pictureService.getCarPictureById(carIdPicture).getPicture();
    }

}
