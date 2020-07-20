package com.marka.journal.service;

import com.marka.journal.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import com.marka.journal.db.UsersDAO;

import java.util.ArrayList;
import java.util.List;

@Component
public class StartupListener {
    @Autowired
    private UsersDAO users;

    @Autowired
    private PasswordEncoder encoder;

    @EventListener
    @Transactional
    public void applicationStarted(ContextRefreshedEvent event) {
        if (users.findRoleByName("ROOT") == null) {
            ArrayList<Role> roles = new ArrayList();
            Role role = users.createRole("ROOT");
            roles.add(role);
            users.createUser("root", encoder.encode("1"), roles);
        }
    }
}
