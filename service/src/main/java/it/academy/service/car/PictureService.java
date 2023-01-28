package it.academy.service.car;

import it.academy.dao.car.CarDao;
import it.academy.dao.car.CarPictureDao;
import it.academy.model.car.Car;
import it.academy.model.car.CarPicture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PictureService {

    @Autowired
    CarPictureDao carPictureDao;

    @Autowired
    CarService carService;

    @Autowired
    CarDao carDao;

    @Transactional
    public CarPicture getCarPictureById(int carPictureId) {
        return carService.getById(carPictureId).getCarPicture();
    }

    @Transactional
    public void changeCarPicture(CarPicture newCarPicture, Car carWithOldPicture) {
        carService.getById(carWithOldPicture.getId()).setCarPicture(newCarPicture);
    }

    @Transactional
    public void findCarBrandModelPriceAndChangeCarPicture(String carBrand,
                                                          String carModel,
                                                          Integer cost,
                                                          byte[] file) {
        Car car = carDao.findCarByBrandModelCost(cost,carBrand,carModel).get(0);
        car.getCarPicture().setPicture(file);
    }
}
