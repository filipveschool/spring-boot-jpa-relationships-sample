package com.filip.springbootstartermysqlsample.onetoonerelationship.models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

// https://hellokoding.com/jpa-one-to-one-foreignkey-relationship-example-with-spring-boot-maven-and-mysql/
@Entity
/*
@Table maps the entity with the table. If no @Table is defined,
the default value is used: the class name of the entity.
 */
@Table(name = "book_detail")
public class BookDetail {

    // @Id declares the identifier property of the entity.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "number_of_pages")
    private Integer numberOfPages;

    // http://javasampleapproach.com/json/resolve-json-infinite-recursion-problems-working-jackson
    @JsonBackReference
    // @OneToOne defines a one-to-one relationship with another entity.
    // mappedBy indicates the entity is the inverse of the relationship.
    @OneToOne(mappedBy = "bookDetail")
    private Book book;

    public BookDetail() {

    }

    public BookDetail(Integer numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(Integer numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
