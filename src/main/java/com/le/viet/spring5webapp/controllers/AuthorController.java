package com.le.viet.spring5webapp.controllers;

import com.le.viet.spring5webapp.repositories.AuthorReppository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by associate on 3/5/18.
 */
@Controller
public class AuthorController {
    private AuthorReppository authorReppository;

    //----- constructor injection
    public AuthorController(AuthorReppository authorReppository) {
        this.authorReppository = authorReppository;
    }
    //----- END

    @RequestMapping("/authors")
    public String getAuthors(Model model) {
        model.addAttribute("authors", this.authorReppository.findAll());
        return "authors"; //'authors' is the template name
    }
}
