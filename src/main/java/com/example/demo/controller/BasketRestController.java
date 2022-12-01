package com.example.demo.controller;

import com.example.demo.dto.DocumentDto;
import com.example.demo.service.DocumentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/catalog/basket")
@Api(value = "/basket", tags = "Корзина")
public class BasketRestController {
    private final DocumentService service;

    @ApiOperation(value = "Получение всех Удалённых менее 7 дней назад документов",
            notes = "Возвращает объекты всех Удалённых менее 7 дней назад документов")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Все Документы, удалённые менее 7 дней назад получены")
    })
    @GetMapping
    public ResponseEntity<List<DocumentDto>> getAllContracts() {
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @ApiOperation(value = "Восстановление документа",
            notes = "Принимает id из URL и Документ. Поле id должно быть null")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Документ восстановлен"),
            @ApiResponse(code = 406, message = "Такой документ уже существует")
    })
    @PatchMapping("/{id}")
    public ResponseEntity<HttpStatus> recoverDocument(@PathVariable("id") @ApiParam(name = "id"
            , value = "Документ", example = "1") Long id) {

        service.recover(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
