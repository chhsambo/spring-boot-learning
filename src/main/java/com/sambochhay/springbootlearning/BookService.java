package com.sambochhay.springbootlearning;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {
    private List<Book> books = List.of(
            new Book("Advanced API Security, 2nd Edition-Apress"),
            new Book("50 Algorithms Every Programmer Should Know Second Edition"),
            new Book("Clean Architectures in Python"),
            new Book("Design and Build Great Web APIs-Pragmatic Bookshelf")
    );

    public List<Book> getBooks() {
        return books;
    }

    public Book create(Book newBook) {
        List<Book> extend = new ArrayList<>(books);
        extend.add(newBook);
        this.books = List.copyOf(extend);
        return  newBook;
    }
}
