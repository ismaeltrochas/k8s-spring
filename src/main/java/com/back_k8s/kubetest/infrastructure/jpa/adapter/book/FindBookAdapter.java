package com.back_k8s.kubetest.infrastructure.jpa.adapter.book;

import com.back_k8s.kubetest.domain.model.Book;
import com.back_k8s.kubetest.domain.port.FindBooksPort;
import com.back_k8s.kubetest.infrastructure.jpa.entity.mapper.BookEntityMapper;
import com.back_k8s.kubetest.infrastructure.jpa.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class FindBookAdapter implements FindBooksPort {

    private final BookRepository bookRepository;
    private final BookEntityMapper bookEntityMapper;

    @Override
    public Mono<Book> findBookById(String id) {
        return bookRepository.findById(id)
                .map(bookEntityMapper::toEntity)
                .switchIfEmpty(Mono.error(() -> new RuntimeException(
                        String.format("There's no books into the database with that id: %s.", id)
                )));
    }

    @Override
    public Flux<Book> findAllBookByNameIn(String name) {
        return bookRepository.findAllBookByNameIn(name)
                .map(this.bookEntityMapper::toEntity)
                .switchIfEmpty(Mono.error(() -> new RuntimeException("There's no books into the database.")));
    }

    @Override
    public Flux<Book> findAllBookByAuthorName(String name) {
        return bookRepository.findAllByAuthor(name)
                .map(this.bookEntityMapper::toEntity)
                .switchIfEmpty(Mono.error(() -> new RuntimeException("")));
    }

    @Override
    public Flux<Book> findAllBookByPriceBetween(Double initPrica, Double finalPrice) {
        return bookRepository.findAllBookByPriceBetween(initPrica, finalPrice)
                .map(this.bookEntityMapper::toEntity);
    }

    @Override
    public Flux<Book> findAllBookByCreationDateBetween(LocalDateTime initDate, LocalDateTime finishDate) {
        return bookRepository.findAllByCreatedAtBetween(initDate, finishDate)
                .map(this.bookEntityMapper::toEntity);
    }

    @Override
    public Flux<Book> findAllBooks() {
        return bookRepository.findAll()
                .map(this.bookEntityMapper::toEntity);
    }

}
