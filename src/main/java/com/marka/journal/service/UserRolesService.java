package com.marka.journal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import com.marka.journal.db.UsersDAO;
import com.marka.journal.model.User;

import java.util.ArrayList;

@Component
public class UserRolesService implements UserDetailsService {
    @Autowired
    private UsersDAO users;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = users.findUserByLogin(username);
        if (user == null) {
            throw new UsernameNotFoundException("No user " + username + " found.");
        }

        ArrayList<GrantedAuthority> roles = new ArrayList<>();
        roles.add(new SimpleGrantedAuthority("ROLE_ROOT"));
        if (username.equals("root")) {
            roles.add(new SimpleGrantedAuthority("ROLE_ROOT"));
        }

        return new org.springframework.security.core.userdetails.User(
                username, user.getEncodedPassword(), roles
        );
    }
}
