package it.academy.controller.rest;

import it.academy.model.car.CarBrand;
import it.academy.service.car.BrandModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/get-rest-brands")
public class CarRestController {

    @Autowired
    BrandModelService brandModelService;

    @GetMapping("")
    public ResponseEntity<List<CarBrand>> getAllBrands() {
        List<CarBrand> brand = brandModelService.getAllCarBrands();
        return new ResponseEntity<>(
                brand,
                HttpStatus.OK);
    }
}
