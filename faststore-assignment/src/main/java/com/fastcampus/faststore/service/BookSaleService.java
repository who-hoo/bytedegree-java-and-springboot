package com.fastcampus.faststore.service;

import com.fastcampus.faststore.entity.Book;
import com.fastcampus.faststore.entity.BookSale;
import com.fastcampus.faststore.entity.DiscountPolicy;
import com.fastcampus.faststore.repository.BookSaleRepository;
import com.fastcampus.faststore.type.DiscountType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class BookSaleService {
    private final BookService bookService;
    private final DiscountPolicyService discountPolicyService;
    private final BookSaleRepository bookSaleRepository;

    // TODO: 책을 찾을 수 없으면 RunTimeException을 발생시키도록 구현하세요. 쿼리는 BookSaleRepository에 이미 선언되어 있습니다.
    @Transactional(readOnly = true)
    public BookSale getOrThrow(Book book) {
        return null;
    }

    @Transactional
    public void registerBookSale(String title, DiscountType discountType, Long discountAmount) {
        Book book = bookService.getOrThrow(title);
        DiscountPolicy policy = discountPolicyService.registerDiscountPolicy(discountType, discountAmount);
        BookSale bookSale = new BookSale(book, policy);
        bookSaleRepository.save(bookSale);
    }
}
