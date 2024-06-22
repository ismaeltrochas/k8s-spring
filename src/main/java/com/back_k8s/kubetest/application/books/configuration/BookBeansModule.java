package com.back_k8s.kubetest.application.books.configuration;

import com.back_k8s.kubetest.application.books.service.BookManagementService;
import com.back_k8s.kubetest.domain.port.CreateBookPort;
import com.back_k8s.kubetest.domain.port.FindBooksPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BookBeansModule {

    @Bean
    public BookManagementService bookManagementService(
            CreateBookPort createBookPort,
            FindBooksPort findBooksPort) {
        return new BookManagementService(createBookPort, findBooksPort);
    }

}
