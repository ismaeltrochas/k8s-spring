package com.back_k8s.kubetest.infrastructure.jpa.mapper;

import com.back_k8s.kubetest.domain.model.Book;
import com.back_k8s.kubetest.domain.model.dto.BookDTO;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.springframework.http.ResponseEntity;
import reactor.core.publisher.Mono;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface BookDTOMapper {

    Book toEntity(BookDTO dto);

     BookDTO toDTO( Book entity);
}
