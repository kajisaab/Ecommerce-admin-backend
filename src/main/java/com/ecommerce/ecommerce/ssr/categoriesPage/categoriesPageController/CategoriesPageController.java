package com.ecommerce.ecommerce.ssr.categoriesPage.categoriesPageController;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/categoriesPage")
public class CategoriesPageController {

    @GetMapping("")
    public String getCategories(Model model) {
        model.addAttribute("pageTitle", "Categories");
        return "categories";
    }

}
