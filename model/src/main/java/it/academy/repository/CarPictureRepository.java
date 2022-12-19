package it.academy.repository;

import it.academy.model.CarPicture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarPictureRepository extends JpaRepository<CarPicture, Integer> {
}
