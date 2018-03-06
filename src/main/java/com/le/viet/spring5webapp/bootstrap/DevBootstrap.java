package com.le.viet.spring5webapp.bootstrap;

import com.le.viet.spring5webapp.model.Author;
import com.le.viet.spring5webapp.model.Book;
import com.le.viet.spring5webapp.model.Publisher;
import com.le.viet.spring5webapp.repositories.AuthorReppository;
import com.le.viet.spring5webapp.repositories.BookRepository;
import com.le.viet.spring5webapp.repositories.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * Created by VTL on 3/4/18.
 */
@Component //this annotation makes this as a spring bean and will wire up by spring context
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent>{

    private AuthorReppository authorReppository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    //---------- field injection
//    @Autowired
//    private AuthorReppository authorReppository;
//    @Autowired
//    private BookRepository bookRepository;
    //---------- END


    //---------- setter injection
//    @Autowired
//    public void setAuthorReppository(AuthorReppository authorReppository) {
//        this.authorReppository = authorReppository;
//    }
//
//    @Autowired
//    public void setBookRepository(BookRepository bookRepository) {
//        this.bookRepository = bookRepository;
//    }
    //---------- END

    //---------- constructor INJECTION of book and author repositories
    public DevBootstrap(AuthorReppository authorReppository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorReppository = authorReppository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }
    //--END

    private void initData() {
        //publisher
        Publisher publisher = new Publisher();
        publisher.setName("foo");

        publisherRepository.save(publisher);

        //Erir
        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Drive Design", "1234", publisher);
        eric.getBooks().add(ddd);

        authorReppository.save(eric);
        bookRepository.save(ddd);

        //Rod
        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Devloplement without EJB", "23444", publisher);
        rod.getBooks().add(noEJB);

        authorReppository.save(rod);
        bookRepository.save(noEJB);
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        initData();
    }
}
