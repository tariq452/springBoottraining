package com.example.huic.controller;

import com.example.huic.dto.StudentDto;
import com.example.huic.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class Studentcontroller {
    @Autowired
    private StudentService studentService;


    @GetMapping("/students")
    public ResponseEntity<List<StudentDto>> getAllProperties(){

        List<StudentDto> propertyDTOList= studentService.getAllStudent();
        return new ResponseEntity<>(propertyDTOList, HttpStatus.OK);

    }

    @PostMapping("/students")
    public ResponseEntity<StudentDto> saveProperty(@RequestBody StudentDto studentDto){


        studentDto= studentService.saveProperty(studentDto);

        return new ResponseEntity<>(studentDto, HttpStatus.CREATED);

    }
}
