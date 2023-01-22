package it.academy.service.user;

import it.academy.dao.user.RoleDao;
import it.academy.dao.user.UserDao;
import it.academy.dao.user.UserInformationDao;
import it.academy.model.user.ApplicationUser;
import it.academy.model.user.Role;
import it.academy.model.user.User;
import it.academy.model.user.UserInformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    UserDao userDao;

    @Autowired
    RoleDao roleDao;

    @Autowired
    UserInformationDao userInformationDao;

    @Transactional
    public void saveUser(User user) {
        userDao.createUser(user);
    }

    @Transactional
    public void addNewUserInformation(UserInformation userInformation) {
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

    @Transactional
    public void createUserWithApplicationUserInfo(ApplicationUser applicationUser, String roleName) {

        User user = new User();
        Role role = roleDao.findRoleByName(roleName);
        applicationUser.setRole(role);
        String pas = applicationUser.getPassword();
        applicationUser.setPassword("{noop}" + pas);

        user.setApplicationUser(applicationUser);
        if(applicationUser.getUser() == null) {
            user.getApplicationUser().setUser(user);
        }
        userDao.createUser(user);
    }

    @Transactional
    public List<String> getAllRoleNames() {
        List<String> roleNames = new ArrayList<>();
        for (Role role : roleDao.findAllRoles()) {
            roleNames.add(role.getRoleName());
        };
        return  roleNames;
    }

    @Transactional
    public void addCustomerUser(UserInformation userInformation, ApplicationUser applicationUser, User user) {
        Role role = roleDao.findRoleByName("user");
        applicationUser.setRole(role);
        String pas = applicationUser.getPassword();
        applicationUser.setPassword("{noop}" + pas);

        user.setApplicationUser(applicationUser);
        if(applicationUser.getUser() == null) {
            user.getApplicationUser().setUser(user);
        }

        user.setUserInformation(userInformation);
        if(userInformation.getUser() == null) {
            user.getUserInformation().setUser(user);
        }

        userDao.createUser(user);

    }

}
