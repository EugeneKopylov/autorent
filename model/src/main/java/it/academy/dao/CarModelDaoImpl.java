package it.academy.dao;

import it.academy.model.car.CarBrand;
import it.academy.model.car.CarModel;
import it.academy.repository.CarModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CarModelDaoImpl implements CarModelDao {

    @Autowired
    CarModelRepository carModelRepository;

    @Override
    public void createModelWithoutBrand(String model) {
        CarModel carModel = new CarModel();
        carModel.setCarModel(model);
        carModelRepository.save(carModel);
    }

    @Override
    public void createModelWithBrand(CarBrand carBrand, String model) {
        CarModel carModel = new CarModel();
        carModel.setBrand(carBrand);
        carModel.setCarModel(model);
        carModelRepository.save(carModel);
    }

    @Override
    public List<CarModel> getAllModel() {
        return carModelRepository.findAll();
    }

    @Override
    public List<CarModel> getAllModelByBrand(CarBrand carBrand) {
        return carBrand.getCarModels();
    }

    @Override
    public void createCarModel(CarModel carModel) {
        carModelRepository.save(carModel);
    }
}
