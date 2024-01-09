package com.ecommerce.ecommerce.ssr.product.productPageController;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/productPage")
public class ProductPageController {

    @GetMapping("")
    public String getProduct(Model model){
        model.addAttribute("pageTitle", "Product");
        return "product";

    }

}
