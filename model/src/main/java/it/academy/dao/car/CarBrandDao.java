package it.academy.dao.car;

import it.academy.model.car.CarBrand;
import it.academy.model.car.CarModel;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarBrandDao {

    void createBrand(String brandName);
    void deleteBrandByName(String brandName);
    CarBrand getCarBrandById(Integer idBrand);
    List<CarBrand> getAllBrands();
    List<String> getAllBrandsNames();
    List<CarModel> getAllModelByBrand(CarBrand carBrand);
    List<String> getAllModelByBrandStringNames(CarBrand carBrand);
    List<CarBrand> findByBrandName(String brandName);

}
