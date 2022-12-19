package it.academy.dao;

import it.academy.model.CarPicture;
import org.springframework.stereotype.Repository;

@Repository
public interface CarPictureDao {

    void AddCarPicture(CarPicture carPicture);
    CarPicture getCarPicture (Integer id);
}
