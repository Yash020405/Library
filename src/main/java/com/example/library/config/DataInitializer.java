package com.example.library.config;

import com.example.library.entity.Author;
import com.example.library.entity.Book;
import com.example.library.repository.AuthorRepository;
import com.example.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class DataInitializer implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    @Autowired
    public DataInitializer(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) {
        // Check if database is empty
        if (authorRepository.count() == 0 && bookRepository.count() == 0) {
            // Create and save authors
            Author author1 = new Author();
            author1.setName("J.K. Rowling");
            author1.setCountry("United Kingdom");

            Author author2 = new Author();
            author2.setName("George Orwell");
            author2.setCountry("United Kingdom");

            Author author3 = new Author();
            author3.setName("J.R.R. Tolkien");
            author3.setCountry("United Kingdom");

            Author author4 = new Author();
            author4.setName("F. Scott Fitzgerald");
            author4.setCountry("United States");

            Author author5 = new Author();
            author5.setName("Jane Austen");
            author5.setCountry("United Kingdom");

            Author author6 = new Author();
            author6.setName("Ernest Hemingway");
            author6.setCountry("United States");

            Author author7 = new Author();
            author7.setName("Leo Tolstoy");
            author7.setCountry("Russia");

            Author author8 = new Author();
            author8.setName("Gabriel Garcia Marquez");
            author8.setCountry("Colombia");

            Author author9 = new Author();
            author9.setName("Haruki Murakami");
            author9.setCountry("Japan");

            Author author10 = new Author();
            author10.setName("Agatha Christie");
            author10.setCountry("United Kingdom");

            List<Author> authors = Arrays.asList(
                    author1, author2, author3, author4, author5,
                    author6, author7, author8, author9, author10);
            authorRepository.saveAll(authors);

            // Create and save books
            Book book1 = new Book();
            book1.setTitle("Harry Potter and the Philosopher's Stone");
            book1.setGenre("Fantasy");
            book1.setAuthor(author1);

            Book book2 = new Book();
            book2.setTitle("1984");
            book2.setGenre("Dystopian");
            book2.setAuthor(author2);

            Book book3 = new Book();
            book3.setTitle("The Hobbit");
            book3.setGenre("Fantasy");
            book3.setAuthor(author3);

            Book book4 = new Book();
            book4.setTitle("The Great Gatsby");
            book4.setGenre("Classic");
            book4.setAuthor(author4);

            Book book5 = new Book();
            book5.setTitle("Pride and Prejudice");
            book5.setGenre("Romance");
            book5.setAuthor(author5);

            Book book6 = new Book();
            book6.setTitle("The Old Man and the Sea");
            book6.setGenre("Fiction");
            book6.setAuthor(author6);

            Book book7 = new Book();
            book7.setTitle("War and Peace");
            book7.setGenre("Historical");
            book7.setAuthor(author7);

            Book book8 = new Book();
            book8.setTitle("One Hundred Years of Solitude");
            book8.setGenre("Magical Realism");
            book8.setAuthor(author8);

            Book book9 = new Book();
            book9.setTitle("Norwegian Wood");
            book9.setGenre("Fiction");
            book9.setAuthor(author9);

            Book book10 = new Book();
            book10.setTitle("Murder on the Orient Express");
            book10.setGenre("Mystery");
            book10.setAuthor(author10);

            List<Book> books = Arrays.asList(
                    book1, book2, book3, book4, book5,
                    book6, book7, book8, book9, book10);
            bookRepository.saveAll(books);

            System.out.println("Sample data initialized successfully");
        }
    }
}