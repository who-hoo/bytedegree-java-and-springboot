package com.fastcampus.faststore.service;

import com.fastcampus.faststore.entity.Book;
import com.fastcampus.faststore.repository.BookRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
public class BookServiceTest {

    @Autowired
    private BookRepository bookRepository;

    private BookService bookService;

    @BeforeEach
    public void setup() {
        bookService = new BookService(bookRepository);
    }

    @AfterEach
    public void tearDown() {
        bookRepository.deleteAll();
    }

    @Test
    public void getOrThrow() {
        Book book = new Book("자바의 정석", "남궁성", 30000L);
        bookRepository.save(book);

        Book result = bookService.getOrThrow("자바의 정석");
        assertThat(result).isNotNull();
        assertThat(result.getTitle()).isEqualTo(book.getTitle());
        assertThat(result.getAuthor()).isEqualTo(book.getAuthor());
        assertThat(result.getPrice()).isEqualTo(book.getPrice());
    }

    @Test
    public void registerBook() {
        bookService.registerBook("자바의 정석", "남궁성", 3000L);

        assertThat(bookRepository.findByTitle("자바의 정석")).isNotNull();
    }
}
