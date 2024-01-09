package com.ecommerce.ecommerce.ssr.transactionPage.transactionPageController;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/transactionsPage")
public class TransactionPageController {

    @GetMapping("")
    public String getTransaction(Model model){
        model.addAttribute("pageTitle", "Transactions");
        return "transactionsPage";
    }
}
