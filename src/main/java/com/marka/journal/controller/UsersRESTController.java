package com.marka.journal.controller;

import com.marka.journal.model.Document;
import com.marka.journal.model.User;
import com.marka.journal.repository.DocumentsRepository;
import com.marka.journal.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

public class UsersRESTController {
    @Autowired
    private UsersRepository usersRepository;

    @GetMapping("/all/users")
    public List<User> foundUsers() {
        ArrayList<User> allUsers = new ArrayList<>();
        for (User user : usersRepository.findAll()) {
            allUsers.add(user);
        }
        return allUsers;

    }
}
