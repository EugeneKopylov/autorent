package it.academy.controller.rest;

import it.academy.dtos.dto.car.BrandModelDto;
import it.academy.dtos.mapper.BrandModelMapper;
import it.academy.service.car.BrandModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/brand-rest")
public class BrandRestController {

    @Autowired
    BrandModelService brandModelService;

    @Autowired
    BrandModelMapper brandModelMapper;

    @GetMapping("/brand{id}.view")
    public ResponseEntity<BrandModelDto> getBrandById(@PathVariable int id) {
        BrandModelDto brandModelDto = brandModelMapper.toDto(brandModelService.getCarBrandById(id));
        return new ResponseEntity<BrandModelDto>(brandModelDto, HttpStatus.OK);
    }

    @Secured(value = {"ROLE_ADMIN"})
    @DeleteMapping("/brand-delete/{name}.do")
    public ResponseEntity<String> deleteBrandByName(@PathVariable String name) {
        brandModelService.deleteBrandByBrandName(name);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
