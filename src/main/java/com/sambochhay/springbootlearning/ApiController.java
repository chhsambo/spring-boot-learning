package com.sambochhay.springbootlearning;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ApiController {

    private final BookService bookService;

    public ApiController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/api/books")
    public List<BookEntity> all() {
        return bookService.getBooks();
    }

    @PostMapping("/api/books")
    public BookEntity newBook(@RequestBody NewBook newBook) {
        return bookService.create(newBook);
    }
}
