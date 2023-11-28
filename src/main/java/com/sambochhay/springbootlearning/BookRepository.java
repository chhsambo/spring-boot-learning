package com.sambochhay.springbootlearning;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<BookEntity, Long> {

    // custom finder
    List<BookEntity> findByTitleContainsIgnoreCase(String title);

    List<BookEntity> findByDescriptionContainsIgnoreCase(String description);

    List<BookEntity> findByTitleContainsOrDescriptionContainsAllIgnoreCase(String title, String description);
}
