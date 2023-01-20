package it.academy.dao.user;

import it.academy.model.user.ApplicationUser;
import it.academy.repository.user.ApplicationUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ApplicationUserDaoImpl implements ApplicationUserDao{

    @Autowired
    ApplicationUserRepository applicationUserRepository;

    @Override
    public ApplicationUser createApplicationUser(ApplicationUser applicationUser) {
        return applicationUserRepository.save(applicationUser);
    }

    @Override
    public ApplicationUser findApplicationUserById(Integer applicationUserId) {
        return applicationUserRepository.findById(applicationUserId).get();
    }
}
