package it.academy.dao.car;

import it.academy.model.car.CarPicture;
import org.springframework.stereotype.Repository;

@Repository
public interface CarPictureDao {

    void AddCarPicture(CarPicture carPicture);
    CarPicture getCarPicture (Integer id);
}
