package com.example.campusbookshare.service;

import com.example.campusbookshare.model.Book;
import com.example.campusbookshare.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public Book createBook(Book book) {
        book.setCreated_at(new Date());
        return bookRepository.save(book);
    }
}