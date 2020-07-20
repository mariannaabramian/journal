package com.marka.journal.controller;

import com.marka.journal.db.UsersDAO;
import com.marka.journal.model.User;
import com.marka.journal.repository.DocumentsRepository;
import com.marka.journal.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.security.Principal;

public class AuthUserInfo {

    @Autowired
    private UsersRepository usersRep;

    public AuthUserInfo(Principal principal_) {
        User user_ = new User();
        String login;

        principal = principal_;

        if (principal != null) {
            authenticated = true;
            login = principal.getName();
            this.user = usersRep.findByLogin(login);

        } else {
            authenticated = false;
            this.user = null;
        }
    };

    private Principal principal;
    private boolean authenticated;
    private User user;

    public boolean isAuthenticated() {
        return authenticated;
    }

    public void setAuthenticated(boolean authenticated) {
        this.authenticated = authenticated;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
