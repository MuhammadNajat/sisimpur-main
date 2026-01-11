package com.sisimpur.library.service;

import com.sisimpur.library.model.Book;
import com.sisimpur.library.model.Author;
import org.springframework.data.jpa.domain.Specification;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.JoinType;

public class BookSpecification {

    public static Specification<Book> hasTitle(String title) {
        return (root, query, cb) -> title == null ? null : cb.like(cb.lower(root.get("title")), "%" + title.toLowerCase() + "%");
    }

    public static Specification<Book> hasGenre(String genre) {
        return (root, query, cb) -> genre == null ? null : cb.equal(cb.lower(root.get("genre")), genre.toLowerCase());
    }

    public static Specification<Book> hasPublishedYear(Integer year) {
        return (root, query, cb) -> year == null ? null : cb.equal(root.get("publishedYear"), year);
    }

    public static Specification<Book> hasAuthorName(String authorName) {
        return (root, query, cb) -> {
            if (authorName == null) return null;
            Join<Book, Author> authorJoin = root.join("authors", JoinType.LEFT);
            return cb.like(cb.lower(authorJoin.get("name")), "%" + authorName.toLowerCase() + "%");
        };
    }

    public static Specification<Book> isAvailable(Boolean available) {
        return (root, query, cb) -> {
            if (available == null) return null;
            if (available) {
                return cb.isNull(root.get("assignedTo"));
            } else {
                return cb.isNotNull(root.get("assignedTo"));
            }
        };
    }
}
