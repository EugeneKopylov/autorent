package it.academy.dao.user;

import it.academy.model.user.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao {

    void createUser(User user);
    List<User> findAllUsersWithPagination(int pageNumber, int pageSize);
    User findUserById(Integer userId);
}
