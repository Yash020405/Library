package com.example.library.service;

import com.example.library.entity.Author;
import com.example.library.entity.Book;
import com.example.library.repository.BookRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class BookServiceTest {

    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private BookService bookService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAllBooks() {
        // Prepare test data
        Author author = new Author();
        author.setId(1L);
        author.setName("Test Author");

        Book book = new Book();
        book.setId(1L);
        book.setTitle("Test Book");
        book.setAuthor(author);

        // Mock repository behavior
        when(bookRepository.findAll()).thenReturn(Arrays.asList(book));

        // Test service method
        List<Book> books = bookService.getAllBooks();

        // Verify results
        assertNotNull(books);
        assertEquals(1, books.size());
        assertEquals("Test Book", books.get(0).getTitle());

        // Verify repository interaction
        verify(bookRepository, times(1)).findAll();
    }

    @Test
    public void testGetAllBooksWithAuthors() {
        // Prepare test data
        Author author = new Author();
        author.setId(1L);
        author.setName("Test Author");

        Book book = new Book();
        book.setId(1L);
        book.setTitle("Test Book");
        book.setAuthor(author);

        // Mock repository behavior
        when(bookRepository.findAllBooksWithAuthors()).thenReturn(Arrays.asList(book));

        // Test service method
        List<Book> books = bookService.getAllBooksWithAuthors();

        // Verify results
        assertNotNull(books);
        assertEquals(1, books.size());
        assertEquals("Test Book", books.get(0).getTitle());
        assertEquals("Test Author", books.get(0).getAuthor().getName());

        // Verify repository interaction
        verify(bookRepository, times(1)).findAllBooksWithAuthors();
    }

    @Test
    public void testSaveBook() {
        // Prepare test data
        Book book = new Book();
        book.setTitle("New Book");

        // Mock repository behavior
        when(bookRepository.save(any(Book.class))).thenReturn(book);

        // Test service method
        Book savedBook = bookService.saveBook(book);

        // Verify results
        assertNotNull(savedBook);
        assertEquals("New Book", savedBook.getTitle());

        // Verify repository interaction
        verify(bookRepository, times(1)).save(book);
    }

    @Test
    public void testUpdateBook() {
        // Prepare test data
        Long bookId = 1L;

        Book existingBook = new Book();
        existingBook.setId(bookId);
        existingBook.setTitle("Old Title");
        existingBook.setGenre("Old Genre");

        Author oldAuthor = new Author();
        oldAuthor.setId(1L);
        existingBook.setAuthor(oldAuthor);

        Book updatedDetails = new Book();
        updatedDetails.setTitle("New Title");
        updatedDetails.setGenre("New Genre");

        Author newAuthor = new Author();
        newAuthor.setId(2L);
        updatedDetails.setAuthor(newAuthor);

        // Mock repository behavior
        when(bookRepository.findById(bookId)).thenReturn(Optional.of(existingBook));
        when(bookRepository.save(any(Book.class))).thenAnswer(invocation -> invocation.getArgument(0));

        // Test service method
        Book result = bookService.updateBook(bookId, updatedDetails);

        // Verify results
        assertNotNull(result);
        assertEquals("New Title", result.getTitle());
        assertEquals("New Genre", result.getGenre());
        assertEquals(newAuthor, result.getAuthor());

        // Verify repository interactions
        verify(bookRepository, times(1)).findById(bookId);
        verify(bookRepository, times(1)).save(existingBook);
    }
}