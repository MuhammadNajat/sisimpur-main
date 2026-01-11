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
@Table(name = "authors")
@NoArgsConstructor
@AllArgsConstructor
public class Author {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @ManyToMany(mappedBy = "authors")
    private List<Book> books;
}