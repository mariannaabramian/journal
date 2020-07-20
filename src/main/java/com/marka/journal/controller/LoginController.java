package com.marka.journal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.marka.journal.repository.UsersRepository;
import com.marka.journal.model.User;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    public static final String
            VERIFIED_USER_NAME_ATTRIBUTE = "verifiedUserName";

    @Autowired
    private UsersRepository users;

    @Autowired
    private PasswordEncoder encoder;

    @GetMapping(path = "/login-page")
    public String loginPage(@RequestParam(required = false) String login,
                            HttpSession session) {
        return "login";
    }

    //    @PostMapping(path = "/submit-login-form")
    public String processLoginForm(HttpSession session,
                                   @RequestParam("usernameField") String username,
                                   @RequestParam("passwordField") String password) {
        if (session.getAttribute(VERIFIED_USER_NAME_ATTRIBUTE) != null) {
            return "redirect:/";
        }

        User user = users.findByLogin(username);

        // encoder.matches(password, user.getEncodedPassword())
        if (user != null && (password == user.getEncodedPassword()) ) {
            session.setAttribute(VERIFIED_USER_NAME_ATTRIBUTE, username);
            return "redirect:/";
        } else {
            return "redirect:/login?login=" + username;
        }
    }
}
