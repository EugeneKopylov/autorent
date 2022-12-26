package it.academy.model.car;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "t_car_picture")
@Getter
@Setter
public class CarPicture implements Serializable {

    @Id
    @Column(name = "f_car_id")
    @GeneratedValue(generator = "foreign_key_gen")
    @GenericGenerator(name = "foreign_key_gen",
            strategy = "foreign",
            parameters = @org.hibernate.annotations.Parameter(name = "property", value = "car")
    )
    private int id;

    @OneToOne(fetch = FetchType.EAGER)
    @PrimaryKeyJoinColumn
    private Car car;

    @Lob
    @Column(name = "car_picture", columnDefinition = "MEDIUMBLOB NOT NULL")
    private byte[] picture;
}
