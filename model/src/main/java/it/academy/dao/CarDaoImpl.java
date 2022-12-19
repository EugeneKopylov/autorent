package it.academy.dao;

import it.academy.model.Car;
import it.academy.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CarDaoImpl implements CarDao {

    @Autowired
    CarRepository carRepository;

    @Override
    public List<Car> findAllCars(int pageNumber, int pageSize) {
        return carRepository.findAll(PageRequest.of(pageNumber, pageSize)).getContent();
    }

    @Override
    public void createCar(Car car) {
        carRepository.save(car);
    }

    @Override
    public Car findById(int id) {
        return carRepository.getOne(id);
    }
}
