package com.example.navinmathew.LibraryRESTAPI.services;

import com.example.navinmathew.LibraryRESTAPI.domain.Book;

import java.util.List;

public interface BookService {

    Book findBookById(Long id);
    List<Book> findAllBooks();
    void saveBook(Book book);
    void deleteBook(Long id);
}
