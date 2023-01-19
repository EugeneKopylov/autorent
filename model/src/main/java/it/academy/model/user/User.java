package it.academy.model.user;

import it.academy.model.car.CarPicture;
import it.academy.model.order.Order;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

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

    @ManyToMany(cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    @JoinTable(
            name = "t_user_role",
            joinColumns = @JoinColumn(name = "f_user_id"),
            inverseJoinColumns = @JoinColumn(name = "f_role_id")
    )
    private Set<Role> roles;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private UserInformation userInformation;

    public User(Set<Role> roles, UserInformation userInformation) {
        this.roles = roles;
        this.userInformation = userInformation;
    }

    public User(UserInformation userInformation) {
        this.userInformation = userInformation;
    }

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", orderList=" + orderList +
                ", roles=" + roles +
                ", userInformation=" + userInformation +
                '}';
    }
}
