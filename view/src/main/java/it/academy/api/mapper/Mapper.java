package it.academy.api.mapper;

import it.academy.api.dto.car.CarCreationFromDto;
import it.academy.api.dto.car.CarDto;
import it.academy.dao.car.CarBrandDao;
import it.academy.dao.car.CarModelDao;
import it.academy.dao.car.CarPictureDao;
import it.academy.model.car.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Mapper {

    @Autowired
    CarBrandDao carBrandDao;

    @Autowired
    CarModelDao carModelDao;

    @Autowired
    CarPictureDao carPictureDao;

    //carDto is string
    public CarDto toDto (Car car) {
        String brand = car.getBrand().getBrandName();
        String carModel = car.getCarModel().getCarModelName();
        String bodyType = car.getBodyType();
        String gearbox = car.getGearbox();
        Integer yearOfProd = car.getYearOfProd();
        String fuelType = car.getFuelType();
        String engineCapacity = car.getEngineCapacity();
        Integer cost = car.getCost();
        String carDescription = car.getCarDescription();
        int idCarPicture = car.getCarPicture().getId();
        return new CarDto(
                brand, carModel, bodyType, gearbox,yearOfProd, fuelType,
                engineCapacity,cost,carDescription, idCarPicture
        );
    }

    public Car toCar (CarDto carDto) {
        return new Car(carBrandDao.findByBrandName(carDto.getBrand()).stream().findFirst().get(),
                carModelDao.findByCarModelName(carDto.getCarModel()).stream().findFirst().get(),
                carDto.getBodyType(), carDto.getGearbox(), carDto.getYearOfProd(),
                carDto.getFuelType(), carDto.getEngineCapacity(), carDto.getCost(),
                carDto.getCarDescription(),carPictureDao.getCarPicture(carDto.getIdCarPicture())
                );
    }
}
