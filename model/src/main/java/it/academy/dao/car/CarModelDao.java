package it.academy.dao.car;

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
    List<CarModel> findByCarModelName(String modelName);
    void deleteCarModelByModelName(String modelName);
    void deleteById(int modelId);
    void deleteModel(CarModel carModel);

}
