package com.ecommerce.ecommerce.ssr.orderPage.orderPageController;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ordersPage")
public class OrderPageController {

    @GetMapping("")
    public String getOrder(Model model){
        model.addAttribute("pageTitle", "Orders");
        return "ordersPage";
    }
}
