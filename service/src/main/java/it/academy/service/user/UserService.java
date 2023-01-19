package it.academy.service.user;

import it.academy.dao.user.UserDao;
import it.academy.model.user.User;
import it.academy.model.user.UserInformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserDao userDao;

    @Transactional
    public void saveUser(User user) {
        userDao.createUser(user);
    }

    @Transactional
    public void addNewUser(UserInformation userInformation) {
        User user = new User();
        user.setUserInformation(userInformation);
        if(userInformation.getUser() == null) {
            user.getUserInformation().setUser(user);
        }
        userDao.createUser(user);
    }

    @Transactional
    public List<User> listOfUsers(int pageNumber, int pageSize) {
        return userDao.findAllUsersWithPagination(pageNumber, pageSize);
    }

    @Transactional
    public User getUserById(Integer userId) {
        return userDao.findUserById(userId);
    }

}
