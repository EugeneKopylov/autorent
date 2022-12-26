package it.academy.dao;

import it.academy.model.car.CarBrand;
import it.academy.model.car.CarModel;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarModelDao {

    void createModelWithoutBrand(String model);
    void createModelWithBrand(CarBrand carBrand, String model);
    List<CarModel> getAllModel();
    List<CarModel> getAllModelByBrand(CarBrand carBrand);
    void createCarModel(CarModel carModel);

}
