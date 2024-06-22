package com.back_k8s.kubetest.infrastructure.jpa.entity.mapper;

import com.back_k8s.kubetest.domain.model.Book;
import com.back_k8s.kubetest.domain.model.BookEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface BookEntityMapper {

    Book toEntity(BookEntity bookEntity);

    BookEntity toDto(Book book);
}
