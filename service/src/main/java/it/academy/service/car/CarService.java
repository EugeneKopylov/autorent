package it.academy.service.car;

import it.academy.dao.car.CarDao;
import it.academy.model.car.Car;
import it.academy.model.car.CarPicture;
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
        System.out.println("can i get here?");
        System.out.println("can i get here?");
        System.out.println("can i get here?");
        System.out.println("can i get here?");
        System.out.println("can i get here?");
        System.out.println("can i get here?");
        System.out.println("can i get here?");
        System.out.println("can i get here?");
        System.out.println("can i get here?");
        if (car.getCarPicture() == null) {
            System.out.println("there is a really null");
            System.out.println("there is a really null");
            System.out.println("there is a really null");
            System.out.println("there is a really null");
            System.out.println("there is a really null");
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
