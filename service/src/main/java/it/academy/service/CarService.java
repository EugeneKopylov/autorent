package it.academy.service;

import it.academy.dao.CarDao;
import it.academy.model.Car;
import it.academy.model.CarPicture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CarService {

    @Autowired
    CarDao carDao;

    @Transactional
    public void addNewCar(Car car, byte[] picture) {

        if (car.getCarPicture() == null) {
            CarPicture pic = new CarPicture();
            pic.setCar(car);
            pic.setPicture(picture);
            car.setCarPicture(pic);
        }
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
}
