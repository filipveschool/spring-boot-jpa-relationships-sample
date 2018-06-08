package com.filip.springbootstartermysqlsample.onetoonerelationship.repositories;

import com.filip.springbootstartermysqlsample.onetoonerelationship.models.BookDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookDetailRepository extends JpaRepository<BookDetail, Long> {
}
