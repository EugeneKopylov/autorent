package it.academy.dao.user;

import it.academy.model.user.UserInformation;
import org.springframework.stereotype.Repository;

@Repository
public interface UserInformationDao {

    UserInformation createUserInformation(UserInformation userInformation);
    UserInformation findUserInformationById(Integer userInformationId);

}
