package com.sambochhay.springbootlearning;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Collections;
import java.util.List;

@Service
public class BookService {

    private final BookRepository repository;

    public BookService(BookRepository repository) {
        this.repository = repository;
    }

    public List<BookEntity> getBooks() {
        return repository.findAll();
    }

    public BookEntity create(NewBook newBook) {
        return repository.saveAndFlush(
                new BookEntity(newBook.title(), newBook.description())
        );
    }

    public List<BookEntity> search(BookSearch bookSearch) {
        if (StringUtils.hasText(bookSearch.title()) && StringUtils.hasText(bookSearch.description())) {
            return repository.findByTitleContainsOrDescriptionContainsAllIgnoreCase(bookSearch.title(), bookSearch.description());
        }

        if (StringUtils.hasText(bookSearch.title())) {
            return repository.findByTitleContainsIgnoreCase(bookSearch.title());
        }

        if (StringUtils.hasText(bookSearch.description())) {
            return repository.findByDescriptionContainsIgnoreCase(bookSearch.description());
        }

        return Collections.emptyList();
    }

    public List<BookEntity> search(UniversalSearch search) {
        BookEntity probe = new BookEntity();
        if (StringUtils.hasText(search.value())) {
            probe.setTitle(search.value());
            probe.setDescription(search.value());
        }

        Example<BookEntity> example = Example.of(probe,
                ExampleMatcher.matchingAny().withIgnoreCase().withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING));
        return repository.findAll(example);
    }
}
