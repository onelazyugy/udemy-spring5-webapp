package com.le.viet.spring5webapp.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by associate on 3/5/18.
 */
@Entity
@Data
@Getter
@Setter
//@RequiredArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode(exclude = {"name", "address"})
public class Publisher {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private String address;
}
