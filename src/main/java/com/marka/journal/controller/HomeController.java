package com.marka.journal.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;
import java.security.Principal;

@Controller
public class HomeController {
    public static final String
            VERIFIED_USER_NAME_ATTRIBUTE = "verifiedUserName";

    @GetMapping("/index")
    public String showMain(HttpSession session,
                           Model model) {


        //Principal principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();


        if (session.getAttribute(VERIFIED_USER_NAME_ATTRIBUTE) != null) {
            model.addAttribute("assigned", true);
        } else {
            model.addAttribute("assigned", false);
        }

        return "/";
    }

    @GetMapping("/profile")
    public String showProfile(Model model) {
        return "profile";
    }

    @GetMapping("/about")
    public String showAbout(Model model) {
        return "about";
    }

    @GetMapping("/support")
    public String showSupport(Model model) {

//        if ( (principal != null) ){
//            model.addAttribute("username", principal.getName());
//        } else {
//            model.addAttribute("username", "");
//        }

        return "support";
    }

    @GetMapping("/developer")
    public String showDeveloper(Model model) {
        return "page1";
    }

    @GetMapping("/guide")
    public String showGuide(HttpSession session,
                            Model model) {

        if (session.getAttribute(VERIFIED_USER_NAME_ATTRIBUTE) != null) {
            model.addAttribute("assigned", true);
        } else {
            model.addAttribute("assigned", false);
        }

        return "guide";
    }

    @GetMapping("/account")
    public String showAccount(Model model) {
        return "page2";
    }

    @GetMapping("/exit")
    public String exit(Model model) {
        return "page1";
    }


}
