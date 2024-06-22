package com.back_k8s.kubetest.application.books.usecase;

import com.back_k8s.kubetest.domain.model.Book;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

public interface  GetBookUseCase {
    Mono<Book> findBookById(String id);
    Flux<Book> findAllBookByNameIn(String name);

    Flux<Book> findAllBookByAuthorName(String name);

    Flux<Book> findAllBookByPrice(Double initPrica, Double finalPrice);

    Flux<Book> findAllBookByCreationDateBetween(LocalDateTime initDate, LocalDateTime finishDate);

    Flux<Book> findAllBooks();
}
