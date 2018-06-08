package com.filip.springbootstartermysqlsample.onetoonerelationship.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

// https://hellokoding.com/jpa-one-to-one-foreignkey-relationship-example-with-spring-boot-maven-and-mysql/
@Entity
/*
@Table maps the entity with the table. If no @Table is defined,
the default value is used: the class name of the entity.
 */
@Table(name = "book")
public class Book {

    // @Id declares the identifier property of the entity.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    /*
    @Column maps the entity's field with the table's column.
    If @Column is omitted, the default value is used: the field name of the entity.
     */
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    // http://javasampleapproach.com/json/resolve-json-infinite-recursion-problems-working-jackson
    @JsonManagedReference
    //@OneToOne defines a one-to-one relationship with another entity.
    @OneToOne(cascade = CascadeType.ALL)
    // @JoinColumn indicates the entity is the owner of the relationship:
    // the corresponding table has a column with a foreign key to the referenced table.
    @JoinColumn(name = "book_detail_id")
    private BookDetail bookDetail;

    public Book() {

    }

    public Book(String name, BookDetail bookDetail) {
        this.name = name;
        this.bookDetail = bookDetail;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BookDetail getBookDetail() {
        return bookDetail;
    }

    public void setBookDetail(BookDetail bookDetail) {
        this.bookDetail = bookDetail;
    }
}
