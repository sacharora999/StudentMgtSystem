package com.example.demostudmgt.service;

import com.example.demostudmgt.dto.StudentDto;

import java.util.List;

public interface StudentService {

    StudentDto addStudent(StudentDto studentDto);
    List<StudentDto> getAllStuds();

    void createStudent(StudentDto student);

    StudentDto getStudentById(Long id);

    void updateStudent(StudentDto student);

    void deleteStudent(Long studentId);
}
