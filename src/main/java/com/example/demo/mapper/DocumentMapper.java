package com.example.demo.mapper;

import com.example.demo.dto.DocumentDto;
import com.example.demo.model.Document;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @author YMS01
 * @date 30.11.2022 14:12
 */
@Mapper
public interface DocumentMapper {
    DocumentMapper INSTANCE = Mappers.getMapper(DocumentMapper.class);

    List<DocumentDto> toDtoList(List<Document> employees);

    Document documentDtoToDocument(DocumentDto documentDto);

    DocumentDto documentToDocumentDto(Document document);
}
