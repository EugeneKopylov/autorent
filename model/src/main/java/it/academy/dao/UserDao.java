package it.academy.dao;

import it.academy.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao {

    void createUser(User user);
    List<User> findAllUsersWithPagination(int pageNumber, int pageSize);
    User findUserById(Integer userId);
}
