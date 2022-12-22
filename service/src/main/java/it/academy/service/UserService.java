package it.academy.service;

import it.academy.dao.UserDao;
import it.academy.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserDao userDao;

    @Transactional
    public void addNewUser(User user) {
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
