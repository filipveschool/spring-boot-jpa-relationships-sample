package com.filip.springbootstartermysqlsample.onetoonerelationship;

import com.filip.springbootstartermysqlsample.onetoonerelationship.models.Book;
import com.filip.springbootstartermysqlsample.onetoonerelationship.repositories.BookDetailRepository;
import com.filip.springbootstartermysqlsample.onetoonerelationship.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OneToOneController {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BookDetailRepository bookDetailRepository;

    @GetMapping("/allbooks")
    public List<Book> getAll(){
        return bookRepository.findAll();
    }
}
