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

    // TODO: getOrThrow 테스트 코드를 작성하세요.
    @Test
    public void getOrThrow() {
    }

    @Test
    public void registerBook() {
        bookService.registerBook("자바의 정석", "남궁성", 3000L);

        assertThat(bookRepository.findByTitle("자바의 정석")).isNotNull();
    }
}
