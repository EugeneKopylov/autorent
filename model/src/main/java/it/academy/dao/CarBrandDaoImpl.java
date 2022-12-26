package it.academy.dao;

import it.academy.model.car.CarBrand;
import it.academy.model.car.CarModel;
import it.academy.repository.CarBrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

    public List<CarModel> getAllModelByBrand(CarBrand carBrand) {
        return carBrand.getCarModels();
    }
}
