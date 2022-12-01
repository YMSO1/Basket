package com.example.demo.controller;

import com.example.demo.dto.ContractDto;
import com.example.demo.service.ContractService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author YMS01
 * @date 30.11.2022 22:23
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/catalog/contract")
@Api(value = "/contract", tags = "Договор")
public class ContractController {

    private final ContractService contractService;

    @ApiOperation(value = "Получение всех Счетов",
            notes = "Возвращает объекты всех Счетов")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Все Счета получены")
    })
    @GetMapping
    public ResponseEntity<List<ContractDto>> getAllContracts() {
        return new ResponseEntity<>(contractService.findAll(), HttpStatus.OK);
    }

    @ApiOperation(value = "Получение Счёта",
            notes = "Принимает id Счёта из URL и возвращает объект Счёта по id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Счёт получен"),
            @ApiResponse(code = 404, message = "Счёт с таким id не найден")
    })
    @GetMapping("/{id}")
    public ResponseEntity<ContractDto> getContractById(@PathVariable("id") @ApiParam(name = "id"
            , value = "Id Счёта", example = "1") Long id) {
        return new ResponseEntity<>(contractService.findById(id), HttpStatus.OK);
    }

    @ApiOperation(value = "Создание Счёта",
            notes = "Принимает объект Счёта. Поле id должно быть null")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Счёт создан"),
            @ApiResponse(code = 406, message = "Такой Счёт уже существует")
    })
    @PostMapping
    public ResponseEntity<HttpStatus> createContract(@RequestBody @ApiParam(name = "Объект"
            , value = "Объект Счёта для создания") ContractDto contractDto) {
        contractService.save(contractDto);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @ApiOperation(value = "Редактирование Счёта",
            notes = "Принимает id из URL и объект Счёта. Поле id должно быть null")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Счёт изменён"),
            @ApiResponse(code = 406, message = "Такой Счёт уже существует")
    })
    @PatchMapping("/{id}")
    ResponseEntity<HttpStatus> updateContract(@PathVariable("id") @ApiParam(name = "id"
            , value = "Id Счёта") Long id, @RequestBody @ApiParam(name = "Счёт"
            , value = "Объект Счёта для редактирования") ContractDto contractDto) {
        contractService.update(id, contractDto);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @ApiOperation(value = "Удаление Счёта",
            notes = "Принимает id Счёта из URL и удаляет Счёт по id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Счёт удалён"),
            @ApiResponse(code = 404, message = "Счёт с таким id не найден")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteContractById(@PathVariable("id") @ApiParam(name = "id"
            , value = "Id Счёта для удаления", example = "1") Long id) {
        contractService.deleteById(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
