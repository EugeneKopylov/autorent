package it.academy.dao;

import it.academy.model.User;
import it.academy.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    UserRepository userRepository;

    @Override
    public void createUser(User user) {
        userRepository.save(user);
    }

    @Override
    public List<User> findAllUsersWithPagination(int pageNumber, int pageSize) {
        return userRepository.findAll(PageRequest.of(pageNumber,pageSize)).getContent();
    }

    @Override
    public User findUserById(Integer userId) {
        return userRepository.findById(userId).isPresent() ? userRepository.findById(userId).get() : null;
    }
}
