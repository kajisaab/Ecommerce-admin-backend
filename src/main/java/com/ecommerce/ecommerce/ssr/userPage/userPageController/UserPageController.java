package com.ecommerce.ecommerce.ssr.userPage.userPageController;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/usersPage")
public class UserPageController {

    @GetMapping("")
    public String getUser(Model model){
        model.addAttribute("pageTitle", "Users");
        return "userPage";
    }
}
