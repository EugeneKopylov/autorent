package it.academy.dao.user;

import it.academy.model.user.UserInformation;
import it.academy.repository.user.UserInformationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserInformationDaoImpl implements UserInformationDao {

    @Autowired
    UserInformationRepository userInformationRepository;

    @Override
    public UserInformation createUserInformation(UserInformation userInformation) {
        return userInformationRepository.save(userInformation);
    }

    @Override
    public UserInformation findUserInformationById(Integer userInformationId) {
        return userInformationRepository.getOne(userInformationId);
    }
}
