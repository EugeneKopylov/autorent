package it.academy.model.user;

import it.academy.model.order.Order;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "t_user")
@AllArgsConstructor
public class User implements Serializable {

    private static final Long serialVersionUID = 3L;

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(
            name = "increment",
            strategy = "org.hibernate.id.IncrementGenerator"
    )
    @Column(name = "user_id")
    private int id;

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private List<Order> orderList;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private UserInformation userInformation;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private ApplicationUser applicationUser;

    public User(UserInformation userInformation) {
        this.userInformation = userInformation;
    }

    public User(ApplicationUser applicationUser) {
        this.applicationUser = applicationUser;
    }

    public User(UserInformation userInformation, ApplicationUser applicationUser) {
        this.userInformation = userInformation;
        this.applicationUser = applicationUser;
    }

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", orderList=" + orderList +
                ", userInformation=" + userInformation +
                '}';
    }
}
