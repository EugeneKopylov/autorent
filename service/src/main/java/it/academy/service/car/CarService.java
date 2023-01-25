package it.academy.service.car;

import it.academy.dao.car.CarBrandDao;
import it.academy.dao.car.CarDao;
import it.academy.dao.car.CarModelDao;
import it.academy.dao.order.OrderDao;
import it.academy.model.car.Car;
import it.academy.model.car.CarBrand;
import it.academy.model.car.CarModel;
import it.academy.model.car.CarPicture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
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

    @Autowired
    OrderDao orderDao;

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
    public List<Car> listOfCarsWithPagination(int pageNumber, int pageSize) {
        return carDao.findAllCarsWithPagination(pageNumber, pageSize);
    }

    @Transactional
    public Car getById(int id) {
        return carDao.findById(id);
    }

    @Transactional
    public Car findCarByBrandModelCost(Integer cost, String brand, String model){
        return carDao.findCarByBrandModelCost(cost, brand, model).get(0);
    }

    @Transactional
    public void deleteCarByBrandModelCost(Integer cost, String brand, String model){
        Car deleteCar = carDao.findCarByBrandModelCost(cost, brand, model).get(0);
        orderDao.deleteByCarId(deleteCar.getId());
        carDao.deleteCar(carDao.findCarByBrandModelCost(cost, brand, model).get(0));
    }

    @Transactional
    public List<Car> getAllCars(){
        return carDao.findAllCars();
    }

    @Transactional
    public void saveCar(Car car){
        carDao.createCar(car);
    }

    @Transactional
    public List<Car> listOfCarsWithSortingBySomethingAndPagination(int pageNumber, int pageSize, String sort){
        if (sort.equals(null)) {
            return carDao.findAllCarsWithPagination(pageNumber, pageSize);
        } else if (sort.equals("ascBrand")){
            return carDao.findAllCarsWithPaginationAndSort(pageNumber,pageSize, Sort.by("gearbox").ascending());
        } else if (sort.equals("descBrand")) {
            return carDao.findAllCarsWithPaginationAndSort(pageNumber, pageSize, Sort.by("gearbox").descending());
        } else return null;
    }

}
