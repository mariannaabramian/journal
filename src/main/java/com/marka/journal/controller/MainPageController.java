package com.marka.journal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class MainPageController {
    @GetMapping("/")
    public String mainPage(Principal principal,
                           ModelMap model) {

        String username = principal.getName();

//        AuthUserInfo authUserInfo = new AuthUserInfo(principal);


//        model.addAttribute("authenticated", authUserInfo.isAuthenticated());

        if (username != "") {
            model.addAttribute("authenticated", true);
            model.addAttribute("username", username);
            model.addAttribute("fio", "ФИО");
        } else {
            model.addAttribute("authenticated", false);
            model.addAttribute("username", "XXX");
            model.addAttribute("fio", "XXX");
        };


        return "index";
    }
}
