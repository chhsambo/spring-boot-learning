package com.sambochhay.springbootlearning;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
class BookEntity {
    private @Id @GeneratedValue Long id;
    private String title;
    private String description;

    protected BookEntity() {
        this(null, null);
    }

    BookEntity(String title, String description) {
        this.id = null;
        this.title = title;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
