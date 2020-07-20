package com.marka.journal.controller;

import com.marka.journal.model.Role;
import com.marka.journal.form.RegistrationForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.marka.journal.db.UsersDAO;

import java.util.ArrayList;

@Controller
public class RegistrationController {
    @Autowired
    private UsersDAO users;

    @Autowired
    private PasswordEncoder encoder;

    @ModelAttribute("form")
    public RegistrationForm createForm() {

        RegistrationForm form = new RegistrationForm();
        form.setLogin("");
        form.setPassword("");

        return form;
    }


    @GetMapping(path = "/user/register")
    public String getRegistrationForm(
            ModelMap model,
            @ModelAttribute("form") RegistrationForm form) {

        //model.addAttribute("data", createData());

        return "register";
    }

    @PostMapping(path = "/user/register")
    public String processRegistrationForm(
            ModelMap model,
            @Validated
            @ModelAttribute("form") RegistrationForm form,
            BindingResult validationResult
    ) {
        //model.addAttribute("data", createData());



        Role role = users.findRoleByName(form.getSelectedRoleName());
        if (role == null) {
            validationResult.addError(
                    new FieldError("form", "selectedGroupName",
                            "No group " + form.getSelectedRoleName() + " found"));
        }

        if (validationResult.hasErrors()) {
            return "register";
        }

        ArrayList<Role> roles= new ArrayList<Role>();
        roles.add(role);

        String encodedPassword = encoder.encode(form.getPassword());

        try {
            users.createUser(form.getLogin(), encodedPassword, roles);
        } catch (Throwable cause) {
            validationResult.addError(
                    new FieldError("form", "login",
                            "User with login " + form.getLogin()
                                    + " is already registered."));

            return "register";
        }

        return "redirect:/login?login=" + form.getLogin();
    }
}
