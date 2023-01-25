package it.academy.dao.car;

import it.academy.model.car.Car;
import it.academy.repository.car.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CarDaoImpl implements CarDao {

    @Autowired
    CarRepository carRepository;

    @Override
    public List<Car> findAllCarsWithPagination(int pageNumber, int pageSize) {
        return carRepository.findAll(PageRequest.of(pageNumber, pageSize)).getContent();
    }

    @Override
    public List<Car> findAllCarsWithPaginationAndSort(int pageNumber, int pageSize, Sort sort) {
        return carRepository.findAll(PageRequest.of(pageNumber, pageSize, sort)).getContent();
    }

    @Override
    public void deleteCar(Car car) {
        carRepository.delete(car);
    }

    @Override
    public void createCar(Car car) {
        carRepository.save(car);
    }

    @Override
    public Car findById(int id) {
        return carRepository.getOne(id);
    }

    @Override
    public List<Car> findCarByBrandModelCost(Integer cost, String brand, String model) {
        return carRepository.findCarByBrandModelCost(cost, brand, model);
    }

    @Override
    public List<Car> findAllCars() {
        return carRepository.findAll();
    }
}
