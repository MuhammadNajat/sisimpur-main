package com.sisimpur.library.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "books")
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "title", length = 255)
    private String title;

    @Column(name = "genre", length = 100)
    private String genre;

    @Column(name = "published_year")
    private int publishedYear;

    @ManyToMany
    @JoinTable(
            name = "book_authors",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id")
    )
    private List<Author> authors;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User assignedTo; // null = available
}
