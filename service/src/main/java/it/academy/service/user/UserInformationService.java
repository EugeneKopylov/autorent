package it.academy.service.user;

import it.academy.dao.user.UserInformationDao;
import it.academy.model.user.UserInformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserInformationService {

    @Autowired
    UserInformationDao userInformationDao;

    @Transactional
    public UserInformation createUserInformation(UserInformation userInformation) {
        return userInformationDao.createUserInformation(userInformation);
    }
}
