package it.academy.service;

import it.academy.dao.CarBrandDao;
import it.academy.dao.CarModelDao;
import it.academy.model.car.CarBrand;
import it.academy.model.car.CarModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BrandModelService {

    @Autowired
    CarBrandDao carBrandDao;

    @Autowired
    CarModelDao carModelDao;

    @Transactional
    public void createModelWithoutBrand(String carModel) {
        carModelDao.createModelWithoutBrand(carModel);
    }

    @Transactional
    public void createModelWithBrand(CarBrand carBrand, String carModel) {

        carModelDao.createModelWithBrand(carBrand, carModel);
    }

    @Transactional
    public void createBrand(String brand) {
        carBrandDao.createBrand(brand);
    }

    @Transactional
    public List<CarModel> getAllModelFromBrand(CarBrand carBrand) {
        return carModelDao.getAllModelByBrand(carBrand);
    }

    @Transactional
    public List<CarBrand> getAllCarBrands() {
        return carBrandDao.getAllBrands();
    }

    @Transactional
    public CarBrand getCarBrandById(int carBrandId) {
        return carBrandDao.getCarBrandById(carBrandId);
    }

    @Transactional
    public void createModel(CarModel carModel) {
        carModelDao.createCarModel(carModel);
    }

}
