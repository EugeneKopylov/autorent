package it.academy.security;

import it.academy.model.user.ApplicationUser;
import it.academy.service.user.ApplicationUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("authService")
public class AuthenticationService implements UserDetailsService {

    @Autowired
    ApplicationUserService applicationUserService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        System.out.println("Call: loadUserByUsername");
        try {
            ApplicationUser applicationUser = applicationUserService.findApplicationUserByNickName(username);
            return new User(
                    applicationUser.getNickname(),
                    applicationUser.getPassword(),
                    true, true, true, true,
                    List.of(new SimpleGrantedAuthority("ROLE_" + applicationUser.getRole().getRoleName()))
            );

        } catch (Exception e) {
            e.printStackTrace();
            throw new UsernameNotFoundException("User not found: " + username, e);
        }
    }
}
