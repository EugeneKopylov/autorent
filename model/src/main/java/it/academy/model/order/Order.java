package it.academy.model.order;

import it.academy.model.car.Car;
import it.academy.model.user.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "t_order")
@NoArgsConstructor
public class Order implements Serializable {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(
            name = "increment",
            strategy = "org.hibernate.id.IncrementGenerator"
    )
    @Column(name = "order_id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "car_id")
    private Car car;

    @Column(name = "date")
    private LocalDateTime date;

    @Column(name = "order_date_from")
    private String orderDateFrom;

    @Column(name = "order_date_to")
    private String orderDateTo;

    @Column(name = "cost")
    private Integer cost;

    public Order(User user, Car car, LocalDateTime date, String orderDateFrom, String orderDateTo, Integer cost) {
        this.user = user;
        this.car = car;
        this.date = date;
        this.orderDateFrom = orderDateFrom;
        this.orderDateTo = orderDateTo;
        this.cost = cost;
    }
}
