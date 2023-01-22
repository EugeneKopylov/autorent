package it.academy.service.user;

import it.academy.dao.user.ApplicationUserDao;
import it.academy.model.user.ApplicationUser;
import it.academy.model.user.User;
import it.academy.model.user.UserInformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ApplicationUserService {

    @Autowired
    ApplicationUserDao applicationUserDao;

    @Transactional
    public ApplicationUser findApplicationUserByNickName(String nickname) {
        return applicationUserDao.findByNickname(nickname);
    }

    @Transactional
    public void updateUserInformation(String oldName,
                                      String nickname,
                                      String firstName,
                                      String lastName,
                                      String phoneNumber,
                                      String email) {
        User user = applicationUserDao.findByNickname(oldName).getUser();
        user.getApplicationUser().setNickname(nickname);
        UserInformation userInformation = user.getUserInformation();
        userInformation.setFirstName(firstName);
        userInformation.setLastName(lastName);
        userInformation.setPhoneNumber(phoneNumber);
        userInformation.setEmail(email);
    }
}
