package com.example.demostudmgt.controller;


import com.example.demostudmgt.dto.StudentDto;
import com.example.demostudmgt.service.StudentService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@AllArgsConstructor
public class StudentController {

    StudentService service;

    @GetMapping("/students/new")
    public String postStudent(Model model){
        StudentDto studentDto = new StudentDto();
        model.addAttribute("student", studentDto);
        return "createstud";
    }

    @GetMapping("/students")
    public String getAllStudents(Model model){
        List<StudentDto> students = service.getAllStuds();
//        System.out.println(students);
        model.addAttribute("students", students);
        return "students";
    }

    @PostMapping("/students")
    public String saveStudent(@Valid @ModelAttribute("student") StudentDto student,
                              BindingResult result,
                              Model model){
        if(result.hasErrors()){
            model.addAttribute("student", student);
            return "createstud";
        }
        System.out.println("Controller Obj :" + student);
        service.createStudent(student);
        return "redirect:/students";
    }

    @GetMapping("/students/{studentId}/edit")
    public String editStudent(@PathVariable("studentId") Long studentId, Model model){
        StudentDto studentDto = service.getStudentById(studentId);
        model.addAttribute("student", studentDto);
        return "editstudent";
    }



    @PostMapping("/students/{studentId}")
    public String updStudent(@PathVariable("studentId") Long studentId,
                             @Valid @ModelAttribute("student") StudentDto student,
                             BindingResult result,
                             Model model){
        if(result.hasErrors()){
            model.addAttribute("student", student);
            return "editstudent";
        }
        student.setId(studentId);
        service.updateStudent(student);
        return "redirect:/students";
    }


    @GetMapping("/students/{studentId}/delete")
    public String delStudent(@PathVariable("studentId") Long studentId){
        service.deleteStudent(studentId);
        return "redirect:/students";
    }


    @GetMapping("/students/{studentId}/view")
    public String viewStudent(@PathVariable("studentId") Long studentId, Model model){
        StudentDto studentDto = service.getStudentById(studentId);
        model.addAttribute("student", studentDto);
        return "viewstudent";
    }

}
