package it.academy.dao.car;

import it.academy.model.car.CarBrand;
import it.academy.model.car.CarModel;
import it.academy.repository.car.CarBrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CarBrandDaoImpl implements CarBrandDao {

    @Autowired
    CarBrandRepository carBrandRepository;

    @Override
    public void createBrand(String brandName) {
        CarBrand carBrand = new CarBrand();
        carBrand.setBrandName(brandName);
        carBrandRepository.save(carBrand);
    }

    @Override
    public CarBrand getCarBrandById(Integer idBrand) {
        return carBrandRepository.findById(idBrand).isPresent() ? carBrandRepository.findById(idBrand).get() : null;
    }

    @Override
    public List<CarBrand> getAllBrands() {
        return carBrandRepository.findAll();
    }

    @Override
    public List<CarModel> getAllModelByBrand(CarBrand carBrand) {
        return carBrand.getCarModels();
    }

    @Override
    public List<CarBrand> findByBrandName(String brandName) {
        return carBrandRepository.findByBrandName(brandName);
    }
}
