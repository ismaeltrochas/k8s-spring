package com.back_k8s.kubetest.domain.model;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;


@Document(collection = "books")
@Getter
@Setter
@Builder
public class BookEntity {

    @Id
    private String id;
    private String name;
    private String description;
    private Integer stock;
    private Integer stockAvailable;
    private String author;
    private Double price;
    private LocalDateTime createdAt;
    private LocalDateTime updateAt;
    private String createdBy;
    private String updatedBy;

}
