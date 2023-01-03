package it.academy.service.car;

import it.academy.dao.car.CarPictureDao;
import it.academy.model.car.CarPicture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PictureService {

    @Autowired
    CarPictureDao carPictureDao;

    @Transactional
    public CarPicture getCarPictureById(int carPictureId) {
        return carPictureDao.getCarPicture(carPictureId);
    }
}