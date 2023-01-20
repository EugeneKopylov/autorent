package it.academy.dao.user;

import it.academy.model.user.ApplicationUser;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicationUserDao {

    ApplicationUser createApplicationUser(ApplicationUser applicationUser);
    ApplicationUser findApplicationUserById(Integer applicationUserId);
    ApplicationUser findByNickname(String nickname);

}
