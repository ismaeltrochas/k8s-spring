package com.back_k8s.kubetest.domain.port;

import com.back_k8s.kubetest.domain.model.Book;
import reactor.core.publisher.Mono;

public interface CreateBookPort {

    Mono<Book> createBook(Book book);
}
