package it.academy.service.user;

import it.academy.dao.user.ApplicationUserDao;
import it.academy.model.user.ApplicationUser;
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
}
