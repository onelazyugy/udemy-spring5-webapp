package com.le.viet.spring5webapp.bootstrap;

import com.le.viet.spring5webapp.model.Author;
import com.le.viet.spring5webapp.model.Book;

/**
 * Created by VTL on 3/4/18.
 */
public class DevBootstrap {
    private void initData() {
        //Erir
        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Drive Design", "1234", "Harper Collins");
        eric.getBooks().add(ddd);

        //Rod
        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Devloplement without EJB", "23444", "Worx");
        rod.getBooks().add(noEJB);
    }
}
