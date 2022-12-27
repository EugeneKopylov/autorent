package it.academy.dao.car;

import it.academy.model.car.CarPicture;
import it.academy.repository.car.CarPictureRepository;
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
