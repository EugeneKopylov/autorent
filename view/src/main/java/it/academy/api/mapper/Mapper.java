package it.academy.api.mapper;

import it.academy.api.dto.car.CarCreationDto;
import it.academy.api.dto.car.CarDto;
import it.academy.dao.car.CarBrandDao;
import it.academy.dao.car.CarModelDao;
import it.academy.model.car.Car;
import it.academy.model.car.CarBrand;
import it.academy.model.car.CarModel;
import it.academy.model.car.CarPicture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class Mapper {

    public CarDto toDto(Car car) {
        String brand = car.getBrand().getBrandName();
        String carModel = car.getCarModel().getCarModelName();
        String bodyType = car.getBodyType();
        String gearbox = car.getGearbox();
        Integer yearOfProd = car.getYearOfProd();
        String fuelType = car.getFuelType();
        String engineCapacity = car.getEngineCapacity();
        Integer cost = car.getCost();
        String carDescription = car.getCarDescription();
        int carIdPicture = car.getCarPicture().getId();

        return new CarDto(brand, carModel, bodyType,
                gearbox, yearOfProd, fuelType, engineCapacity,
                cost, carDescription, carIdPicture);
    }

    public Car toCar(CarCreationDto carDto) {
        return new Car(new CarBrand(carDto.getBrand()), new CarModel(carDto.getCarModel()), carDto.getBodyType(),
                carDto.getGearbox(), carDto.getYearOfProd(), carDto.getFuelType(), carDto.getEngineCapacity(),
                carDto.getCost(), carDto.getCarDescription(), new CarPicture(carDto.getCarPicture()));
    }
}
