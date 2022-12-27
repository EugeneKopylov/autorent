package it.academy.repository.car;

import it.academy.model.car.CarPicture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarPictureRepository extends JpaRepository<CarPicture, Integer> {
}
