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

        AuthUserInfo authUserInfo = new AuthUserInfo(principal);

        model.addAttribute("authenticated", authUserInfo.isAuthenticated());

        if (authUserInfo.isAuthenticated()) {
            model.addAttribute("username", authUserInfo.getUser().getLogin());
            model.addAttribute("fio", authUserInfo.getUser().formFIO());
        };

        return "index";
    }
}
