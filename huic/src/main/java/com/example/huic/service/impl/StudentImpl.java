package com.example.huic.service.impl;

import com.example.huic.dto.StudentDto;
import com.example.huic.entity.StudentEntity;
import com.example.huic.repository.StudentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.huic.service.StudentService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private ModelMapper modelMapper;

    private StudentDto studentDto;
    @Override
    public List<StudentDto> getAllStudent() {
        List<StudentEntity> studentEntityList =(List<StudentEntity>) studentRepository.findAll();
        List<StudentDto> studentDtos = new ArrayList<>();
        for( StudentEntity pe: studentEntityList){
            StudentDto dto= modelMapper.map(pe,StudentDto.class);
            studentDtos.add(dto);
        }
        return studentDtos;
    }

    @Override
    public StudentDto saveProperty(StudentDto studentDto) {
        Optional<StudentEntity>  optionalStudentEntity = studentRepository.findById(studentDto.getId());
        if(optionalStudentEntity.isEmpty()){


            StudentEntity pe = modelMapper.map(studentDto,StudentEntity.class);


            pe = studentRepository.save(pe);

            StudentDto dto= modelMapper.map(pe,StudentDto.class);
            return studentDto;
        }
        return studentDto;
    }}
