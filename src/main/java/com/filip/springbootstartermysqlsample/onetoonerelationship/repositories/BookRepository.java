package com.filip.springbootstartermysqlsample.onetoonerelationship.repositories;

import com.filip.springbootstartermysqlsample.onetoonerelationship.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
}
