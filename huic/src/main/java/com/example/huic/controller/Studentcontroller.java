package com.example.huic.controller;

import com.example.huic.dto.StudentDto;
import com.example.huic.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/student")
public class Studentcontroller {
    @Autowired
    private StudentService studentService;


    @GetMapping("/students")
    public ResponseEntity<List<StudentDto>> getAllProperties(){

        List<StudentDto> propertyDTOList= studentService.getAllStudent();
        return new ResponseEntity<>(propertyDTOList, HttpStatus.OK);


    }
}
