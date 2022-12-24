package it.academy.api.dto;

import it.academy.model.CarPicture;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class CarDto {

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
