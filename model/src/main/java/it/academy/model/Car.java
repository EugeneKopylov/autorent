package it.academy.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity(name = "car")
@Getter
@Setter
@Table(name = "t_car")
public class Car {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(
            name = "increment",
            strategy = "org.hibernate.id.IncrementGenerator"
    )
    private Integer id;

    //todo - brand и model закинуть в отдельную таблицу
    @Column(name = "brand")
    private String brand;

    @Column(name = "model")
    private String model;

    @Column(name = "body_type")
    private String bodyType;

    //todo - тоже можно в отельную
    @Column(name = "gearbox")
    private String gearbox;

    @Column(name = "year_of_prod")
    private Integer yearOfProd;

    //todo - двигатель и тип топлива можно в отдельную таблицу
    @Column(name = "fuel_type")
    private String fuelType;

    @Column(name = "engine_capacity")
    private String engineCapacity;

    @Column(name = "cost")
    private Integer cost;

    @Column(name = "car_description")
    private String carDescription;

    @OneToOne(mappedBy = "car", cascade = CascadeType.ALL)
    CarPicture carPicture;

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", bodyType='" + bodyType + '\'' +
                ", gearbox='" + gearbox + '\'' +
                ", yearOfProd=" + yearOfProd +
                ", fuelType='" + fuelType + '\'' +
                ", engineCapacity='" + engineCapacity + '\'' +
                ", cost=" + cost +
                ", carDescription='" + carDescription + '\'' +
//                ", carPicture=" + carPicture +
                '}';
    }
}
