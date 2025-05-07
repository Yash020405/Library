package com.example.library.service;

import com.example.library.entity.Author;
import com.example.library.repository.AuthorRepository;
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

public class AuthorServiceTest {

    @Mock
    private AuthorRepository authorRepository;

    @InjectMocks
    private AuthorService authorService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAllAuthors() {
        // Prepare test data
        Author author = new Author();
        author.setId(1L);
        author.setName("Test Author");
        author.setCountry("Test Country");

        // Mock repository behavior
        when(authorRepository.findAll()).thenReturn(Arrays.asList(author));

        // Test service method
        List<Author> authors = authorService.getAllAuthors();

        // Verify results
        assertNotNull(authors);
        assertEquals(1, authors.size());
        assertEquals("Test Author", authors.get(0).getName());
        assertEquals("Test Country", authors.get(0).getCountry());

        // Verify repository interaction
        verify(authorRepository, times(1)).findAll();
    }

    @Test
    public void testGetAuthorById() {
        // Prepare test data
        Long authorId = 1L;
        Author author = new Author();
        author.setId(authorId);
        author.setName("Test Author");
        author.setCountry("Test Country");

        // Mock repository behavior
        when(authorRepository.findById(authorId)).thenReturn(Optional.of(author));

        // Test service method
        Optional<Author> foundAuthor = authorService.getAuthorById(authorId);

        // Verify results
        assertNotNull(foundAuthor);
        assertEquals(true, foundAuthor.isPresent());
        assertEquals("Test Author", foundAuthor.get().getName());
        assertEquals("Test Country", foundAuthor.get().getCountry());

        // Verify repository interaction
        verify(authorRepository, times(1)).findById(authorId);
    }

    @Test
    public void testSaveAuthor() {
        // Prepare test data
        Author author = new Author();
        author.setName("New Author");
        author.setCountry("New Country");

        // Mock repository behavior
        when(authorRepository.save(any(Author.class))).thenReturn(author);

        // Test service method
        Author savedAuthor = authorService.saveAuthor(author);

        // Verify results
        assertNotNull(savedAuthor);
        assertEquals("New Author", savedAuthor.getName());
        assertEquals("New Country", savedAuthor.getCountry());

        // Verify repository interaction
        verify(authorRepository, times(1)).save(author);
    }

    @Test
    public void testUpdateAuthor() {
        // Prepare test data
        Long authorId = 1L;

        Author existingAuthor = new Author();
        existingAuthor.setId(authorId);
        existingAuthor.setName("Old Name");
        existingAuthor.setCountry("Old Country");

        Author updatedDetails = new Author();
        updatedDetails.setName("New Name");
        updatedDetails.setCountry("New Country");

        // Mock repository behavior
        when(authorRepository.findById(authorId)).thenReturn(Optional.of(existingAuthor));
        when(authorRepository.save(any(Author.class))).thenAnswer(invocation -> invocation.getArgument(0));

        // Test service method
        Author result = authorService.updateAuthor(authorId, updatedDetails);

        // Verify results
        assertNotNull(result);
        assertEquals("New Name", result.getName());
        assertEquals("New Country", result.getCountry());

        // Verify repository interactions
        verify(authorRepository, times(1)).findById(authorId);
        verify(authorRepository, times(1)).save(existingAuthor);
    }
}