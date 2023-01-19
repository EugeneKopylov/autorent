package it.academy.repository.car;

import it.academy.model.car.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Integer> {

    @Query("SELECT c FROM car c WHERE c.cost = :cost AND c.brand.brandName = :brandName AND c.carModel.carModelName = :carModelName")
    List<Car> findCarByBrandModelCost(@Param("cost") Integer cost,
                             @Param("brandName") String brandName,
                             @Param("carModelName") String carModelName);

}
