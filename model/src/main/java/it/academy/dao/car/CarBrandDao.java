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
    List<String> getAllBrandsNames();
    //todo сделать поиск модели через данный метод - исключает возможность
    // использования иного бренда при совпадении имен моделей у брендов
    List<CarModel> getAllModelByBrand(CarBrand carBrand);
    List<String> getAllModelByBrandStringNames(CarBrand carBrand);
    List<CarBrand> findByBrandName(String brandName);

}
