package it.academy.api.dto;

import it.academy.model.car.CarPicture;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class CarCreationDto {

    private String brand;
    private String carModel;
    private String bodyType;
    private String gearbox;
    private Integer yearOfProd;
    private String fuelType;
    private String engineCapacity;
    private Integer cost;
    private String carDescription;
    private CarPicture carPicture;

}
