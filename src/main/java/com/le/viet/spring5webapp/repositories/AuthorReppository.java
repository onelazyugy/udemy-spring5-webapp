package com.le.viet.spring5webapp.repositories;

import com.le.viet.spring5webapp.model.Author;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by VTL on 3/4/18.
 */
public interface AuthorReppository extends CrudRepository<Author, Long> {

}
