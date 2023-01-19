package it.academy.service.car;

import it.academy.dao.car.CarBrandDao;
import it.academy.dao.car.CarDao;
import it.academy.dao.car.CarModelDao;
import it.academy.model.car.Car;
import it.academy.model.car.CarBrand;
import it.academy.model.car.CarModel;
import it.academy.model.car.CarPicture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CarService {

    @Autowired
    CarDao carDao;

    @Autowired
    CarBrandDao carBrandDao;

    @Autowired
    CarModelDao carModelDao;

    @Transactional
    public void addNewCar(Car car, byte[] picture) {
        CarBrand carBrand = carBrandDao.findByBrandName(car.getBrand().getBrandName()).get(0);
        CarModel carModel = carModelDao.findByCarModelName(car.getCarModel().getCarModelName()).get(0);
        car.setBrand(carBrand);
        car.setCarModel(carModel);
        car.setCarPicture(null);
        CarPicture pic = new CarPicture();
        pic.setCar(car);
        pic.setPicture(picture);
        car.setCarPicture(pic);
        carDao.createCar(car);
    }

    @Transactional
    public List<Car> listOfCars(int pageNumber, int pageSize) {
        return carDao.findAllCars(pageNumber, pageSize);
    }

    @Transactional
    public Car getById(int id) {
        return carDao.findById(id);
    }

    @Transactional
    public Car findCarByBrandModelCost(Integer cost, String brand, String model){
        return carDao.findCarByBrandModelCost(cost, brand, model).get(0);
    }

}
