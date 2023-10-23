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
}
