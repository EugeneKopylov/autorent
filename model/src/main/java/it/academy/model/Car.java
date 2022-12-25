package it.academy.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity(name = "car")
@Getter
@Setter
@Table(name = "t_car")
@NoArgsConstructor
@AllArgsConstructor
public class Car implements Serializable {

    @Id
    @Column(name = "car_id")
    @GeneratedValue(generator = "increment")
    @GenericGenerator(
            name = "increment",
            strategy = "org.hibernate.id.IncrementGenerator"
    )
    private int id;

    //todo - brand и model закинуть в отдельную таблицу
    @Column(name = "brand")
    private String brand;

    @Column(name = "car_model")
    private String carModel;

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

/*    @OneToOne(mappedBy = "car", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private CarPicture carPicture;*/

    @OneToOne(mappedBy = "car", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private CarPicture carPicture;

    @OneToMany(mappedBy = "car")
    private List<Order> orders;

    public Car(String brand, String carModel, String bodyType, String gearbox,
               Integer yearOfProd, String fuelType, String engineCapacity,
               Integer cost, String carDescription, CarPicture carPicture) {
        this.brand = brand;
        this.carModel = carModel;
        this.bodyType = bodyType;
        this.gearbox = gearbox;
        this.yearOfProd = yearOfProd;
        this.fuelType = fuelType;
        this.engineCapacity = engineCapacity;
        this.cost = cost;
        this.carDescription = carDescription;
        this.carPicture = carPicture;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", model='" + carModel + '\'' +
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
