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
    public String newBook(@ModelAttribute NewBook newBook) {
        bookService.create(newBook);
        return "redirect:/";
    }

    @PostMapping("/multi-field-search")
    public String multiFieldSearch(@ModelAttribute BookSearch search, Model model) {
        List<BookEntity> searchResult = bookService.search(search);
        model.addAttribute("books", searchResult);
        return "index";
    }

    @PostMapping("/universal-search")
    public String universalSearch(@ModelAttribute UniversalSearch search, Model model) {
        List<BookEntity> searchResults = bookService.search(search);
        model.addAttribute("books", searchResults);
        return "index";
    }
}
