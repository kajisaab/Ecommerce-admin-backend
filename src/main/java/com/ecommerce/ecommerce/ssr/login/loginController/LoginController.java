package com.ecommerce.ecommerce.ssr.login.loginController;

import jakarta.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/login")
public class LoginController {
    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    @GetMapping("")
    public String getLogin(@RequestParam(name = "error", required = false) String error, Model model, HttpSession session){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (error != null) {
            model.addAttribute("errorMessage", "Authentication failed: " + error);
        }
        if(authentication == null || authentication instanceof AnonymousAuthenticationToken) {
            return "login";
        }

        return "redirect:/dashboardPage";
    }
}
