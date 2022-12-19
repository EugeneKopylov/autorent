package it.academy.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "t_car_picture")
@Getter
@Setter
public class CarPicture {

    @Id
    @Column(name = "ID")
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    @OneToOne
    @JoinColumn(name = "car_id")
    private Car car;

    @Lob
    @Column(name = "car_picture", columnDefinition = "MEDIUMBLOB NOT NULL")
    private byte[] carPicture;
}
