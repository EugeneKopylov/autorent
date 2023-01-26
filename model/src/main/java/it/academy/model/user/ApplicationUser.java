package it.academy.model.user;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "t_app_user")
public class ApplicationUser {

    @Id
    @Column(name = "f_app_user_id")
    @GeneratedValue(generator = "foreign_key_gen")
    @GenericGenerator(name = "foreign_key_gen",
                      strategy = "foreign",
                      parameters = @org.hibernate.annotations.Parameter(name = "property", value = "user"))
    private int id;

    @OneToOne
    @PrimaryKeyJoinColumn
    private User user;

    @Column(name = "nickname", unique = true)
    private String nickname;

    @Column(name = "password")
    private String password;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

}
