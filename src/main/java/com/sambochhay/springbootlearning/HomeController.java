package com.sambochhay.springbootlearning;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class HomeController {
    private final BookService bookService;

    public HomeController(BookService bookService) {
        this.bookService = bookService;
    }
    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("books", bookService.getBooks());
        return "index";
    }

    @PostMapping("/new-book")
    public String newBook(@ModelAttribute Book newBook) {
        bookService.create(newBook);
        return "redirect:/";
    }
}
