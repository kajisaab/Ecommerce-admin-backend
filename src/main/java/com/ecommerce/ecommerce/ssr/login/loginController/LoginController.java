package com.ecommerce.ecommerce.ssr.login.loginController;

import com.ecommerce.ecommerce.core.expception.BadRequestException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/loginPage")
public class LoginController {
    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    @GetMapping("")
    public String getLogin(@RequestParam(name = "error", required = false) String error, Model model,  HttpSession session){
        System.out.println("THis is error " + error);
        if (error != null) {
            session.setAttribute("errorMessage", "Authentication failed: " + error);
        }
        return "loginPage";
    }

//    @GetMapping("")
//    public String getLogin(@RequestParam(name = "error", required = false) String error, HttpServletRequest request) {
//        HttpSession session = request.getSession(true);
//        System.out.println("This is error " + error + session.getAttribute("errorMessage"));
//
////        // Check if there is an error message in the session
////        if (session.getAttribute("errorMessage") != null) {
////            request.setAttribute("errorMessage", session.getAttribute("errorMessage"));
////
////            // Remove the error message from the session
////            session.removeAttribute("errorMessage");
////        } else if (error != null) {
////            // Set the error message to the session
////            request.setAttribute("errorMessage", "Authentication failed: " + error);
////            session.setAttribute("errorMessage", "Authentication failed: " + error);
////        } else {
////            // No error or message from the session, clear the attribute
////            request.setAttribute("errorMessage", null);
////        }
//
//
//        return "loginPage";
//    }
}
