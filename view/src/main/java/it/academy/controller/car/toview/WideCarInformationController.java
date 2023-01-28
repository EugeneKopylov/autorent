package it.academy.controller.car.toview;

import it.academy.model.car.Car;
import it.academy.model.car.CarPicture;
import it.academy.service.car.CarService;
import it.academy.service.car.PictureService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WideCarInformationController {

    @Autowired
    CarService carService;

    @Autowired
    PictureService pictureService;

    @GetMapping("/car-list/{brand}/{model}/{price}.view")
    public ModelAndView getWidInformationAboutCar(@PathVariable String brand,
                                                  @PathVariable String model,
                                                  @PathVariable Integer price,
                                                  Model modelPage){

        modelPage.addAttribute("car", carService.findCarByBrandModelCost(price,brand,model));

        return new ModelAndView("wide_car_information");
    }

    @ResponseBody
    @GetMapping("/image/wide/{car.carPicture.id}/picture.jpg")
    public byte[] getToWideImage(@PathVariable("car.carPicture.id") int carIdPicture) {
        return pictureService.getCarPictureById(carIdPicture).getPicture();
    }

    @PostMapping("change-car-picture.action")
    @SneakyThrows
    public String changeCarPicture(@RequestParam("picture") MultipartFile file,
                                   @RequestParam String brand,
                                   @RequestParam String model,
                                   @RequestParam Integer price) {
        pictureService.findCarBrandModelPriceAndChangeCarPicture(brand, model, price, file.getBytes());
        return "redirect:/car-list/off0pgs3.view";     //"redirect:/car-list/{" + brand + "}/{" + model + "}/{" + price + "}.view";redirect:/car-list/off0pgs3.view
    }
}
