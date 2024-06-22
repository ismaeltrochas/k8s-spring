package com.back_k8s.kubetest.infrastructure.jpa.adapter.book;

import com.back_k8s.kubetest.domain.model.Book;
import com.back_k8s.kubetest.domain.port.CreateBookPort;
import com.back_k8s.kubetest.infrastructure.jpa.entity.mapper.BookEntityMapper;
import com.back_k8s.kubetest.infrastructure.jpa.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class CreateBookAdapter implements CreateBookPort {

    private final BookRepository bookRepository;
    private final BookEntityMapper bookEntityMapper;

    @Override
    public Mono<Book> createBook(Book book) {
        return Mono.fromCallable(() -> bookEntityMapper.toDto(book))
                .flatMap(bookRepository::save)
                .map(bookEntityMapper::toEntity);
    }

}
