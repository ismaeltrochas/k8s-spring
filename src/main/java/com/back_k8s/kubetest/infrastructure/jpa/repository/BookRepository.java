package com.back_k8s.kubetest.infrastructure.jpa.repository;

import com.back_k8s.kubetest.domain.model.BookEntity;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

import java.time.LocalDateTime;

@Repository
public interface BookRepository extends ReactiveMongoRepository<BookEntity, String> {

    Flux<BookEntity> findAllByAuthor(String name);

    Flux<BookEntity> findAllByCreatedAtBetween(LocalDateTime initDate, LocalDateTime finishDate);

    Flux<BookEntity> findAllBookByPriceBetween(Double initPrice, Double finishPrice);

    Flux<BookEntity> findAllBookByNameIn(String name);

}
