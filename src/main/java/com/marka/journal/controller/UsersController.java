package com.marka.journal.controller;

import com.marka.journal.model.User;
import com.marka.journal.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;

@Controller
public class UsersController {

    @Autowired
    private UsersRepository usersRep;

    @GetMapping("/users")
    public String listUsers(Model model) {

        ArrayList<User> allUsers = new ArrayList<>();
        usersRep.findAll().
                forEach(allUsers::add);

        model.addAttribute("users", allUsers);
        return "users";
    }


}
