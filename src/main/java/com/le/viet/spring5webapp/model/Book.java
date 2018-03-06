package com.le.viet.spring5webapp.model;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by VTL on 3/4/18.
 */
@Entity
@Data
@Getter
@Setter
@RequiredArgsConstructor
@ToString
@EqualsAndHashCode(exclude = {"title", "isbn", "publisher"})
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private final String title;
    private final String isbn;
    @OneToOne
    private final Publisher publisher;
    @ManyToMany
    @JoinTable(name = "author_book", joinColumns = @JoinColumn(name = "book_id"), inverseJoinColumns = @JoinColumn(name = "author_id"))
    private Set<Author> authors = new HashSet<>();
}
