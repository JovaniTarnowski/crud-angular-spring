package com.tarnowski.crudspring.controller;

import com.tarnowski.crudspring.service.StudentService;
import com.tarnowski.crudspring.service.dto.StudentDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/courses/")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping("/{id}/students")
    public List<StudentDTO> listAllStudents(@PathVariable(value = "id") Long id){
        return studentService.listAllStudents(id);
    }

}
