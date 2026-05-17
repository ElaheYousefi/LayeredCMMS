package dadeAndisheNiroo.common.security;

import dadeAndisheNiroo.authentication.model.UserModel;
import dadeAndisheNiroo.authentication.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomsUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {

        System.out.println("username="+ username);
        System.out.println("username.length="+ username.length());
        UserModel user = userRepository
                .findByUsername(username)
                .orElseThrow(() ->
                        new UsernameNotFoundException("User not found"));

        System.out.println("pass="+ user.getPassword());
        System.out.println("pass.length="+ user.getPassword().length());
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        System.out.println("MATCH TEST = " +
                encoder.matches("1234", user.getPassword()));
        return new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPassword(),
                List.of(new SimpleGrantedAuthority(user.getRole()))
        );
    }
}
