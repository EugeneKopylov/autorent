package it.academy.dao.car;

import it.academy.model.car.CarBrand;
import it.academy.model.car.CarModel;
import it.academy.repository.car.CarModelRepository;
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
        carModel.setCarModelName(model);
        carModelRepository.save(carModel);
    }

    @Override
    public void createModelWithBrand(CarBrand carBrand, String model) {
        CarModel carModel = new CarModel();
        carModel.setBrand(carBrand);
        carModel.setCarModelName(model);
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

    @Override
    public List<CarModel> findByCarModelName(String modelName) {
        return carModelRepository.findByCarModelName(modelName);
    }

    @Override
    public void deleteCarModelByModelName(String modelName) {
        carModelRepository.delete(carModelRepository.findByCarModelName(modelName).get(0));
    }

    @Override
    public void deleteById(int modelId) {
/*        CarModel carModel = carModelRepository.getOne(modelId);
        carModelRepository.delete(carModel);*/
        carModelRepository.deleteById(modelId);
    }

    @Override
    public void deleteModel(CarModel carModel) {
        carModelRepository.delete(carModel);
    }
}
