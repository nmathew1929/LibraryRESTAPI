package com.example.navinmathew.LibraryRESTAPI.controllers;

import com.example.navinmathew.LibraryRESTAPI.domain.Book;
import com.example.navinmathew.LibraryRESTAPI.domain.User;
import com.example.navinmathew.LibraryRESTAPI.services.BookService;
import com.example.navinmathew.LibraryRESTAPI.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(BookController.BASE_URL)
public class BookController {
    public static final String BASE_URL = "/api/v1/books";

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    List<Book> getAllBooks() {
        return bookService.findAllBooks();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Book getBookById(@PathVariable Long id) {
        return bookService.findBookById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Book createBook(@RequestBody Book book) {
        return bookService.saveBook(book);
    }

//    @PostMapping("{/id}")
//    @ResponseStatus(HttpStatus.CREATED)
//    public Book createBookOldAuthor(@RequestBody Book book) {
//        return bookService.saveBook(book);
//    }

    @PutMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Book updateBook(@RequestBody Book book) {
        return bookService.saveBook(book);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public @ResponseBody void deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
    }
}
