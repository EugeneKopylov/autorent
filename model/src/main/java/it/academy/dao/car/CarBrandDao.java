package it.academy.dao.car;

import it.academy.model.car.CarBrand;
import it.academy.model.car.CarModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarBrandDao {

    void createBrand(String brandName);
    CarBrand getCarBrandById(Integer idBrand);
    List<CarBrand> getAllBrands();
    public List<CarModel> getAllModelByBrand(CarBrand carBrand);
    List<CarBrand> findByBrandName(String brandName);

}
