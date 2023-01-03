package it.academy.repository.car;

import it.academy.model.car.CarBrand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarBrandRepository extends JpaRepository<CarBrand, Integer> {

    List<CarBrand> findByBrandName(String brandName);
}
