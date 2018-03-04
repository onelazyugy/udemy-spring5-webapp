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
@ToString
@RequiredArgsConstructor //must set the final as final
@EqualsAndHashCode(exclude = {"firstName", "lastName", "books"})
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    //we only want a constructor with firstName and lastName
    private final String firstName;
    private final String lastName;
    @ManyToMany(mappedBy = "authors")
    private Set<Book> books = new HashSet<>();


}
