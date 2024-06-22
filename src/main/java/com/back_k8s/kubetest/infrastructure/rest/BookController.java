package com.back_k8s.kubetest.infrastructure.rest;

import com.back_k8s.kubetest.application.books.service.BookManagementService;
import com.back_k8s.kubetest.domain.model.dto.BookDTO;
import com.back_k8s.kubetest.infrastructure.jpa.mapper.BookDTOMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(path = "/books")
@RequiredArgsConstructor
public class BookController {

    private final BookManagementService bookManagementService;
    private final BookDTOMapper bookDTOMapper;

    @GetMapping(value = "/findById/{bookId}")
    public Mono<ResponseEntity<BookDTO>> findBookById(@PathVariable("bookId") String id) {
        return bookManagementService.findBookById(id)
                .map(book -> ResponseEntity.ok(bookDTOMapper.toDTO(book)))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Mono<ResponseEntity<BookDTO>> createBook(
            @RequestBody BookDTO bookDTO,
            @RequestHeader("created_by") String createdBy) {
        return bookManagementService.createBook(bookDTOMapper.toEntity(bookDTO), createdBy)
                .map(book -> ResponseEntity.ok(bookDTOMapper.toDTO(book)))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @GetMapping(path = "/findAll")
    public Flux<BookDTO> findAllBooks() {
        return bookManagementService.findAllBooks()
                .map(bookDTOMapper::toDTO);
    }

    @GetMapping(path = "/findByName")
    public Flux<BookDTO> findAllByName(@RequestParam(name = "name") String name) {
        return bookManagementService.findAllBookByNameIn(name)
                .map(this.bookDTOMapper::toDTO);
    }
}
