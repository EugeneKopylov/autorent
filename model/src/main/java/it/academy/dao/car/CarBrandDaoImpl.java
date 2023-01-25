package it.academy.dao.car;

import it.academy.model.car.CarBrand;
import it.academy.model.car.CarModel;
import it.academy.repository.car.CarBrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
    public void deleteBrandByName(String brandName) {
        carBrandRepository.delete(carBrandRepository.findByBrandName(brandName).get(0));
    }



    @Override
    public List<String> getAllBrandsNames() {
        List<CarBrand> carBrands = carBrandRepository.findAll();
        List<String> test = new ArrayList<>();
        for (CarBrand carBrand : carBrands) {
            test.add(carBrand.getBrandName());
        }
        return test;
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
    public List<String> getAllModelByBrandStringNames(CarBrand carBrand) {
        return carBrand.getCarModels().stream().map(CarModel::getCarModelName).collect(Collectors.toList());
    }

    @Override
    public List<CarBrand> findByBrandName(String brandName) {
        return carBrandRepository.findByBrandName(brandName);
    }
}
