package com.filip.springbootstartermysqlsample.onetoonerelationship;

import com.filip.springbootstartermysqlsample.onetoonerelationship.models.Book;
import com.filip.springbootstartermysqlsample.onetoonerelationship.models.BookDetail;
import com.filip.springbootstartermysqlsample.onetoonerelationship.repositories.BookDetailRepository;
import com.filip.springbootstartermysqlsample.onetoonerelationship.repositories.BookRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class SetupDataLoaderOneToOne implements ApplicationListener<ContextRefreshedEvent> {

    private static final Logger LOGGER = LoggerFactory.getLogger(SetupDataLoaderOneToOne.class);
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BookDetailRepository bookDetailRepository;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        addOneToOneRelationShips();
    }

    public void addOneToOneRelationShips() {

        // save a couple of books
        Book books1 = new Book("Book A", new BookDetail(49));
        bookRepository.saveAndFlush(books1);

        Book book2 = new Book("Book B", new BookDetail(59));
        bookRepository.saveAndFlush(book2);

        Book book3 = new Book("Book C", new BookDetail(69));
        bookRepository.saveAndFlush(book3);

        // fetch all books
        for (Book book : bookRepository.findAll()) {
            LOGGER.info(book.toString());
        }
    }

}
