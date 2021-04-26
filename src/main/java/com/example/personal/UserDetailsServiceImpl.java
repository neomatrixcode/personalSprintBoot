package com.example.personal;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import static java.util.Collections.emptyList;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private PersonalRepository personalRepository;

    public UserDetailsServiceImpl(PersonalRepository personalRepository) {
        this.personalRepository = personalRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Personal applicationUser = personalRepository.findByUsuario(username);
        if (applicationUser == null) {

            throw new UsernameNotFoundException(username);
        }
        return new User(applicationUser.getUsuario(), applicationUser.getContrasenia(), emptyList());
    }
}

