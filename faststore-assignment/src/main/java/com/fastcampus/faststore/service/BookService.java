package com.fastcampus.faststore.service;

import com.fastcampus.faststore.entity.Book;
import com.fastcampus.faststore.repository.BookRepository;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;

    @Transactional(readOnly = true)
    public Book getOrThrow(String title) {
        return bookRepository.findByTitle(title)
                .orElseThrow(() -> new RuntimeException("해당 제목의 책이 존재하지 않습니다."));
    }

    @Transactional
    public void registerBook(String title, String author, Long price) {
        Optional<Book> newBook = bookRepository.findByTitle(title);
        if (newBook.isPresent()) {
            throw new RuntimeException("동일한 책이 이미 존재합니다.");
        } else {
            bookRepository.save(new Book(title, author, price));
        }
    }
}
