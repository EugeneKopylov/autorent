package it.academy.model.car;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "car_model")
public class CarModel {

    @Id
    @Column(name = "f_model_id")
    @GeneratedValue(generator = "increment")
    @GenericGenerator(
            name = "increment",
            strategy = "org.hibernate.id.IncrementGenerator"
    )
    private int id;

    @ManyToOne
    @JoinColumn(name = "f_brand_id")
    private CarBrand brand;

    @OneToMany(mappedBy = "carModel")
    private List<Car> cars;

    @Column(name = "car_model_name")
    private String carModelName;
}
