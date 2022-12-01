package com.example.demo.controller;

import com.example.demo.dto.CompanyDto;
import com.example.demo.service.CompanyService;
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
 * @date 01.12.2022 0:38
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/catalog/company")
@Api(value = "/company", tags = "Компания")
public class CompanyRestController {
    private final CompanyService companyService;

    @ApiOperation(value = "Получение всех Компаний",
            notes = "Возвращает объекты всех Компаний")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Все Компании получены")
    })
    @GetMapping
    public ResponseEntity<List<CompanyDto>> getAllCompany() {
        return new ResponseEntity<>(companyService.findAll(), HttpStatus.OK);
    }

    @ApiOperation(value = "Получение Компании",
            notes = "Принимает id Компании из URL и возвращает объект Компании по id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Компания получена"),
            @ApiResponse(code = 404, message = "Компания с таким id не найдена")
    })
    @GetMapping("/{id}")
    public ResponseEntity<CompanyDto> getCompanyById(@PathVariable("id") @ApiParam(name = "id"
            , value = "Id Компании", example = "1") Long id) {
        return new ResponseEntity<>(companyService.findById(id), HttpStatus.OK);
    }

    @ApiOperation(value = "Создание Компании",
            notes = "Принимает объект Компании. Поле id должно быть null")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Компания создана"),
            @ApiResponse(code = 406, message = "Такая Компания уже существует")
    })
    @PostMapping
    public ResponseEntity<HttpStatus> createCompany(@RequestBody @ApiParam(name = "Объект"
            , value = "Объект Компании для создания") CompanyDto companyDto) {
        companyService.save(companyDto);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @ApiOperation(value = "Редактирование Компании",
            notes = "Принимает id из URL и объект Компании. Поле id должно быть null")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Компания изменена"),
            @ApiResponse(code = 406, message = "Такая Компания уже существует")
    })
    @PatchMapping("/{id}")
    ResponseEntity<HttpStatus> updateCompany(@PathVariable("id") @ApiParam(name = "id"
            , value = "Id Компании") Long id, @RequestBody @ApiParam(name = "Компания"
            , value = "Объект Компании для редактирования") CompanyDto companyDto) {
        companyService.update(id, companyDto);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @ApiOperation(value = "Удаление Компании",
            notes = "Принимает id Компании из URL и удаляет Компанию по id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Компания удалена"),
            @ApiResponse(code = 404, message = "Компания с таким id не найдена")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteCompanyById(@PathVariable("id") @ApiParam(name = "id"
            , value = "Id Компании для удаления", example = "1") Long id) {
        companyService.deleteById(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
