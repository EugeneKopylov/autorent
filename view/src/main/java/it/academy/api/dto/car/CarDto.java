package it.academy.api.dto.car;

import it.academy.model.car.CarBrand;
import it.academy.model.car.CarModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CarDto {

//    private ModelBrand brand;
    private CarBrand brand;
    private CarModel carModel;
    private String bodyType;
    private String gearbox;
    private Integer yearOfProd;
    private String fuelType;
    private String engineCapacity;
    private Integer cost;
    private String carDescription;
    private int idCarPicture;

}
