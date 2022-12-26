package it.academy.dao;

import it.academy.model.car.Car;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarDao {

    List<Car> findAllCars(int pageNumber, int pageSize);

    void createCar(Car car);

    Car findById(int id);
}
