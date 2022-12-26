package it.academy.controller;

import it.academy.dao.CarModelDao;
import it.academy.model.car.CarBrand;
import it.academy.model.car.CarModel;
import it.academy.repository.CarModelRepository;
import it.academy.service.BrandModelService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Controller
public class AddCarModelWithBrand {

    @Autowired
    BrandModelService brandModelService;

    @GetMapping("/add-car-model.view")
    public ModelAndView showAddCarModelPage() {
        List<CarBrand> brands = brandModelService.getAllCarBrands();
        System.out.println("--------------------------------------------");
        brands.forEach(System.out::println);
        System.out.println("--------------------------------------------");
        return new ModelAndView(
                "add_car_model",
                Map.of("brands", brands)
        );
    }

    @PostMapping("/add-car-model.action")
    @SneakyThrows
    public String addCarModel(CarModel carModel) {
//        System.out.println("This is carBrandId" + carBrandId);
        //CarBrand carBrand = brandModelService.getCarBrandById(carBrandId);
        //CarBrand cb = brandModelService.getCarBrandById(2);
//        brandModelService.createModelWithBrand(cb, carModel);
        System.out.println("i'am nothing to do");
        System.out.println("i'am nothing to do");
        System.out.println("i'am nothing to do");
        System.out.println("i'am nothing to do");
        System.out.println("i'am nothing to do");
 /*       CarModel carModel1 = new CarModel(1,new CarBrand(), "gfhjk");
        carModel.save(carModel1);*/
        brandModelService.createModel(carModel);
        return "redirect:/add-car-model.view";
    }
}
