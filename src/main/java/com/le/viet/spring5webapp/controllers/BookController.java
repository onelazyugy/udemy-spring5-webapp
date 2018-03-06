package com.le.viet.spring5webapp.controllers;

import com.le.viet.spring5webapp.repositories.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by associate on 3/5/18.
 */
@Controller
public class BookController {
    private BookRepository bookRepository;

    //----- constructor injection
    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    //----- END

    @RequestMapping("/books")
    public String getBooks(Model model) {
        //get list of books from db
        model.addAttribute("books", this.bookRepository.findAll());
        return "books";//'books' is a view name
    }
}
