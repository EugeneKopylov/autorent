package it.academy.controller.car.toview;

import it.academy.service.car.CarService;
import it.academy.service.car.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
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
}
