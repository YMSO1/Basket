package com.example.demo.controller;

import com.example.demo.dto.EmployeeDto;
import com.example.demo.service.EmployeeService;
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

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/catalog/employee")
@Api(value = "/employee", tags = "Сотрудники")
public class EmployeeRestController {

    private final EmployeeService service;

    @ApiOperation(value = "Получение всех Сотрудников",
            notes = "Возвращает объекты всех Сотрудников")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Все Сотрудники получены")
    })
    @GetMapping
    public ResponseEntity<List<EmployeeDto>> getAllEmployee() {

        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @ApiOperation(value = "Получение Сотрудника",
            notes = "Принимает id Сотрудника из URL и возвращает объект Сотрудника по id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Сотрудник получен"),
            @ApiResponse(code = 404, message = "Сотрудник с таким id не найден")
    })
    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable("id") @ApiParam(name = "id"
            , value = "Id Сотрудника", example = "1") Long id) {

        return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
    }

    @ApiOperation(value = "Создание Сотрудника",
            notes = "Принимает объект Сотрудник. Поле id должно быть null")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Сотрудник создан"),
            @ApiResponse(code = 406, message = "Такой Сотрудник уже существует")
    })
    @PostMapping
    public ResponseEntity<HttpStatus> createEmployee(@RequestBody @ApiParam(name = "Объект"
            , value = "Объект Сотрудник для создания") EmployeeDto employeeDTO) {

        service.save(employeeDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @ApiOperation(value = "Редактирование Сотрудника",
            notes = "Принимает id из URL и Сотрудника. Поле id должно быть null")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Сотрудник изменен"),
            @ApiResponse(code = 406, message = "Такой Сотрудник уже существует")
    })
    @PatchMapping("/{id}")
    public ResponseEntity<HttpStatus> updateEmployee(@PathVariable("id") @ApiParam(name = "id"
            , value = "Сотрудник") Long id, @RequestBody @ApiParam(name = "Сотрудник"
            , value = "Сотрудник для редактирования") EmployeeDto employeeDTO) {

        service.update(id, employeeDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @ApiOperation(value = "Удаление Сотрудника",
            notes = "Принимает id Сотрудника из URL и удаляет Сотрудника по id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Сотрудник удален"),
            @ApiResponse(code = 404, message = "Сотрудник с таким id не найден")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteEmployeeById(@PathVariable("id") @ApiParam(name = "id"
            , value = "Id Сотрудника для удаления", example = "1") Long id) {

        service.deleteById(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
