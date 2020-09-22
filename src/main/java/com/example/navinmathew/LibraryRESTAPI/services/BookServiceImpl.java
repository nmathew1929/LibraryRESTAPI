package com.example.navinmathew.LibraryRESTAPI.services;

import com.example.navinmathew.LibraryRESTAPI.domain.Book;
import com.example.navinmathew.LibraryRESTAPI.repositories.AuthorRepository;
import com.example.navinmathew.LibraryRESTAPI.repositories.BookRepository;
import com.example.navinmathew.LibraryRESTAPI.repositories.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final CategoryRepository categoryRepository;

    public BookServiceImpl(BookRepository bookRepository, AuthorRepository authorRepository, CategoryRepository categoryRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.categoryRepository = categoryRepository;
    }

    public Book findBookById(Long id) {
        return bookRepository.findById(id).get();
    }

    @Override
    public List<Book> findAllBooks() {
        //Book book = bookRepository.findByTitle("Shingeki no kyojin");
        //System.out.println("This is from the BookServiceImpl + " + book.getAuthor());
        //System.out.println("This is also testing stuff out: " + authorRepository.findAuthorByFirstnameAndLastname("hajime", "isayama").isPresent());
        //System.out.println("This is also testing stuff out: " + categoryRepository.findCategoryByCategoryname("thriller").isPresent());

        return bookRepository.findAll();
    }

    @Override
    public Book saveBook(Book book) {
        //need to check if author exists.
        //need to check if category exists.
        //boolean authorcheck = authorRepository.findAuthorByFirstnameAndLastname(book.getAuthors().
        //boolean categorycheck = categoryRepository.findCategoryByCategoryname(book.getCategory().getCategoryname()).isPresent();
        //if(authorcheck && categorycheck) {
        //    System.out.println("Categories/Author already in the db.");
        //    return book;
        //} else  {
            return bookRepository.save(book);
        //}
    }

    @Override
    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }

}
