package it.academy.repository.user;

import it.academy.model.user.ApplicationUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicationUserRepository extends JpaRepository<ApplicationUser, Integer> {

    ApplicationUser findByNickname(String nickname);
}
