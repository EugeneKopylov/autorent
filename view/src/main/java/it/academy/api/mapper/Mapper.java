package it.academy.api.mapper;

import it.academy.api.dto.CarDto;
import it.academy.model.car.Car;
import org.springframework.stereotype.Component;

@Component
public class Mapper {

    public CarDto toDto (Car car) {
/*        String brand = car.getBrand();
        String carModel = car.getCarModel();*/
//        ModelBrand brand = car.getBrand();
        String bodyType = car.getBodyType();
        String gearbox = car.getGearbox();
        Integer yearOfProd = car.getYearOfProd();
        String fuelType = car.getFuelType();
        String engineCapacity = car.getEngineCapacity();
        Integer cost = car.getCost();
        String carDescription = car.getCarDescription();
        int idCarPicture = car.getCarPicture().getId();
        return new CarDto(
                /*brand,*/ bodyType, gearbox,
                yearOfProd, fuelType, engineCapacity, cost,
                carDescription, idCarPicture
        );
    }

/*    public Car toCar (CarCreationDto carDto) {
        return new Car(
                carDto.getBrand(), carDto.getCarModel(), carDto.getBodyType(),
                carDto.getGearbox(), carDto.getYearOfProd(), carDto.getFuelType(),
                carDto.getEngineCapacity(), carDto.getCost(), carDto.getCarDescription(),
                carDto.getCarPicture()
        );
    }*/
}
