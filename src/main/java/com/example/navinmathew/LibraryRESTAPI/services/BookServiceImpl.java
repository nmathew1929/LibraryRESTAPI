package com.example.navinmathew.LibraryRESTAPI.services;

import com.example.navinmathew.LibraryRESTAPI.domain.Author;
import com.example.navinmathew.LibraryRESTAPI.domain.Book;
import com.example.navinmathew.LibraryRESTAPI.domain.Category;
import com.example.navinmathew.LibraryRESTAPI.repositories.AuthorRepository;
import com.example.navinmathew.LibraryRESTAPI.repositories.BookRepository;
import com.example.navinmathew.LibraryRESTAPI.repositories.CategoryRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final CategoryRepository categoryRepository;
    private final EntityManager entityManager;

    public BookServiceImpl(BookRepository bookRepository, AuthorRepository authorRepository, CategoryRepository categoryRepository, EntityManager entityManager) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.categoryRepository = categoryRepository;
        this.entityManager = entityManager;
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
    @Transactional
    public void saveBook(Book book) {
        Optional<Author> authorOptional = authorRepository.findAuthorByFirstnameAndLastname(book.getAuthor().getFirstname(), book.getAuthor().getLastname());
        Boolean authorcheck = authorOptional.isPresent();
        Optional<Category> categoryOptional= categoryRepository.findCategoryByCategoryname(book.getCategory().getCategoryname());
        Boolean categorycheck = categoryOptional.isPresent();
        if(authorcheck && categorycheck) {
            System.out.println("Categories & Author already in the db.");
            entityManager.createNativeQuery("INSERT INTO Book (title, author_id, category_id) VALUES (?, ?, ?)")
                    .setParameter(1, book.getTitle())
                    .setParameter(2, authorOptional.get().getId())
                    .setParameter(3, categoryOptional.get().getId())
                    .executeUpdate();

        }else if (authorcheck){
            System.out.println("I have to create a new category.");
            entityManager.createNativeQuery("INSERT INTO Category(categoryname) VALUES (?)")
                    .setParameter(1, book.getCategory().getCategoryname())
                    .executeUpdate();
            Long id =  categoryRepository.findCategoryByCategoryname(book.getCategory().getCategoryname()).get().getId();
            entityManager.createNativeQuery("INSERT INTO Book (title, author_id, category_id) VALUES (?, ?, ?)")
                    .setParameter(1, book.getTitle())
                    .setParameter(2, authorOptional.get().getId())
                    .setParameter(3, id)
                    .executeUpdate();
        }else if (categorycheck){
            System.out.println("I have to create a new author.");
            entityManager.createNativeQuery("INSERT INTO Author(firstname, lastname) VALUES (?, ?)")
                    .setParameter(1, book.getAuthor().getFirstname())
                    .setParameter(2, book.getAuthor().getLastname())
                    .executeUpdate();
            Long id =  authorRepository.findAuthorByFirstnameAndLastname(book.getAuthor().getFirstname(), book.getAuthor().getLastname()).get().getId();
            entityManager.createNativeQuery("INSERT INTO Book (title, author_id, category_id) VALUES (?, ?, ?)")
                    .setParameter(1, book.getTitle())
                    .setParameter(2, id)
                    .setParameter(3, categoryOptional.get().getId())
                    .executeUpdate();

        }
         else {
            bookRepository.save(book);
        }
    }

    @Override
    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }

}
