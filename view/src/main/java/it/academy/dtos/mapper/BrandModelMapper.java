package it.academy.dtos.mapper;

import it.academy.dtos.dto.car.BrandModelDto;
import it.academy.model.car.CarBrand;
import it.academy.model.car.CarModel;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BrandModelMapper {

    public BrandModelDto toDto(CarBrand carBrand) {
        String brand = carBrand.getBrandName();
        List<String> modelsOfBrand = new ArrayList<String>();
        List<CarModel> carModels = carBrand.getCarModels();
        for(CarModel carModel : carModels) {
            modelsOfBrand.add(carModel.getCarModelName());
        }
        return new BrandModelDto(brand, modelsOfBrand);
    }
}
