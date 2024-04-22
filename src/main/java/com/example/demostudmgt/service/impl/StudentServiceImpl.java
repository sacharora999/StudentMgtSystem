package com.example.demostudmgt.service.impl;

import com.example.demostudmgt.dto.StudentDto;
import com.example.demostudmgt.entity.Student;
import com.example.demostudmgt.repo.StudentRepo;
import com.example.demostudmgt.service.StudentService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class StudentServiceImpl implements StudentService {

    private StudentRepo studentRepo;
    private ModelMapper mapper;

    @Override
    public StudentDto addStudent(StudentDto studentDto) {
        Student student = mapper.map(studentDto, Student.class);
        Student savedStudent = studentRepo.save(student);
        StudentDto dto = mapper.map(savedStudent, StudentDto.class);
        return dto;
    }

    @Override
    public List<StudentDto> getAllStuds() {
        List<Student> list = studentRepo.findAll();
//        System.out.println(list);
        List<StudentDto> newDtoList = list.stream().map(student -> mapper.map(student, StudentDto.class )).collect(Collectors.toList());
        return newDtoList;
    }

    @Override
    public void createStudent(StudentDto student) {
        System.out.println(student);
        Student stud = mapper.map(student, Student.class);
        System.out.println(stud);
        studentRepo.save(stud);
    }

    @Override
    public StudentDto getStudentById(Long id) {
        Student student = studentRepo.findById(id).get();
        return mapper.map(student, StudentDto.class);
    }

    @Override
    public void updateStudent(StudentDto student) {
        Student stud = studentRepo.findById(student.getId()).get();
        stud.setFirstname(student.getFirstname());
        stud.setLastname(student.getLastname());
        stud.setEmail(student.getEmail());
        studentRepo.save(stud);
    }

    @Override
    public void deleteStudent(Long studentId) {
        studentRepo.deleteById(studentId);
    }
}
