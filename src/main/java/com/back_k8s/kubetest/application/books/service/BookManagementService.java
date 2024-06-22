package com.back_k8s.kubetest.application.books.service;

import com.back_k8s.kubetest.application.books.usecase.CreateBookUseCase;
import com.back_k8s.kubetest.application.books.usecase.GetBookUseCase;
import com.back_k8s.kubetest.domain.model.Book;
import com.back_k8s.kubetest.domain.port.CreateBookPort;
import com.back_k8s.kubetest.domain.port.FindBooksPort;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@RequiredArgsConstructor
public class BookManagementService implements CreateBookUseCase, GetBookUseCase {

    private final CreateBookPort createBookPort;
    private final FindBooksPort findBooksPort;

    @Override
    public Mono<Book> createBook(Book bookDTO,String createdBy) {
        bookDTO.setCreatedAt(LocalDateTime.now());
        return createBookPort.createBook(bookDTO);
    }


    @Override
    public Mono<Book> findBookById(String id) {
        return findBooksPort.findBookById(id);
    }

    @Override
    public Flux<Book> findAllBookByNameIn(String name) {
        return findBooksPort.findAllBookByNameIn(name);
    }

    @Override
    public Flux<Book> findAllBookByAuthorName(String name) {
        return findBooksPort.findAllBookByAuthorName(name);
    }

    @Override
    public Flux<Book> findAllBookByPrice(Double initPrica, Double finalPrice) {
        return findBooksPort.findAllBookByPriceBetween(initPrica, finalPrice);
    }

    @Override
    public Flux<Book> findAllBookByCreationDateBetween(LocalDateTime initDate, LocalDateTime finishDate) {
        return findBooksPort.findAllBookByCreationDateBetween(initDate, finishDate);
    }

    @Override
    public Flux<Book> findAllBooks() {
        return findBooksPort.findAllBooks();
    }

}
