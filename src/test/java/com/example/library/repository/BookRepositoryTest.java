package com.example.library.repository;

import com.example.library.entity.Author;
import com.example.library.entity.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
public class BookRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private BookRepository bookRepository;

    @Test
    public void testFindAllBooksWithAuthors() {
        // Create test author
        Author author = new Author();
        author.setName("Test Author");
        author.setCountry("Test Country");
        entityManager.persist(author);

        // Create test book
        Book book = new Book();
        book.setTitle("Test Book");
        book.setGenre("Test Genre");
        book.setAuthor(author);
        entityManager.persist(book);

        entityManager.flush();

        // Test the custom query method
        List<Book> books = bookRepository.findAllBooksWithAuthors();

        assertNotNull(books);
        assertEquals(1, books.size());
        assertNotNull(books.get(0).getAuthor());
        assertEquals("Test Author", books.get(0).getAuthor().getName());
    }
}