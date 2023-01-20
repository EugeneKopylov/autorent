package it.academy.dao.car;

import it.academy.model.car.Car;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarDao {

    List<Car> findAllCarsWithPagination(int pageNumber, int pageSize);

    void createCar(Car car);

    Car findById(int id);

    List<Car> findCarByBrandModelCost(@Param("cost") Integer cost,
                                      @Param("brand") String brand,
                                      @Param("model") String model);

    List<Car> findAllCars();
}
