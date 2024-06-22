package com.back_k8s.kubetest.domain.model;

import lombok.*;

import java.time.LocalDateTime;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    private String id;
    private String name;
    private String description;
    private Integer stock;
    private Integer stockAvailable;
    private String author;
    private String category;
    private Double price;
    private LocalDateTime createdAt;
    private LocalDateTime updateAt;
    private String createdBy;
    private String updatedBy;
}
