package com.example.demo.service;

import com.example.demo.dto.DocumentDto;
import com.example.demo.mapper.DocumentMapper;
import com.example.demo.model.Document;
import com.example.demo.repository.DocumentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author YMS01
 * @date 30.11.2022 14:29
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class DocumentServiceImpl implements DocumentService {
    private final DocumentRepository repository;

    @Override
    public List<DocumentDto> findAll() {
        log.info("All Documents was found");
        return DocumentMapper.INSTANCE.toDtoList(repository.findAllNotRemoved());
    }

    public List<DocumentDto> findAllToBasket() {
        log.info("All Documents was found");
        return DocumentMapper.INSTANCE.toDtoList(repository.findAllRemovedToBasket());
    }

    @Override
    public DocumentDto findById(Long id) {
        log.info("Document with id = {} was found", id);
        return DocumentMapper.INSTANCE.documentToDocumentDto(repository.findDocumentByIdIfNotRemoved(id));
    }

    @Override
    @Transactional
    public void save(DocumentDto documentDto) {
        Document document = DocumentMapper.INSTANCE.documentDtoToDocument(documentDto);

        document.setIsRemoved(false);
        repository.save(document);
        log.info("Document was saved: {}", document);
    }

    @Override
    @Transactional
    public void update(Long id, DocumentDto documentDto) {
        Document fromDto = DocumentMapper.INSTANCE.documentDtoToDocument(documentDto);
        Document newDocument = repository.findDocumentByIdIfNotRemoved(id);

        newDocument.setIsRemoved(false);
        repository.save(newDocument);
        log.info("Employee was updated: {}", newDocument);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        repository.markDocumentAsRemoved(id);
        log.info("Document with id = {} was marked as removed", id);
    }

    @Override
    @Transactional
    public void recover(Long id) {
        repository.markDocumentAsNotRemoved(id);
    }
}
