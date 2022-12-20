package it.academy.dao;

import it.academy.model.CarPicture;
import it.academy.repository.CarPictureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CarPictureDaoImpl implements CarPictureDao {

    @Autowired
    CarPictureRepository carPictureRepository;

    @Override
    public void AddCarPicture(CarPicture carPicture) {
        carPictureRepository.save(carPicture);
    }

    @Override
    public CarPicture getCarPicture(Integer id) {
        return carPictureRepository.getOne(id);
    }
}