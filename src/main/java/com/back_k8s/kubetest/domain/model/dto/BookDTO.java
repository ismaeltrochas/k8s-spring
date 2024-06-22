package com.back_k8s.kubetest.domain.model.dto;


import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookDTO {
    private String name;
    private String description;
    private Integer stock;
    private Integer stockAvailable;
    private String createdBy;
    private String author;
    private Double price;
}
