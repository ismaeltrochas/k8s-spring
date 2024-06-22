package com.back_k8s.kubetest.application.books.usecase;

import com.back_k8s.kubetest.domain.model.Book;
import reactor.core.publisher.Mono;

public interface CreateBookUseCase {
    Mono<Book> createBook(Book bookDTO,String createdBy);
}
