package com.tarnowski.crudspring.controller;

import com.tarnowski.crudspring.service.StudentService;
import com.tarnowski.crudspring.service.dto.StudentDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/courses/")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping("/{id}/students")
    public ResponseEntity<List<StudentDTO>> listAllStudents(@PathVariable(value = "id") Long id){
        List<StudentDTO> studentDTO = studentService.listAllStudents(id);
        return new ResponseEntity<>(studentDTO, HttpStatus.OK);
    }

    @PostMapping("/students")
    public ResponseEntity<StudentDTO> createStudent(@Valid @RequestBody StudentDTO studentDTO){
        StudentDTO student =  studentService.save(studentDTO);
        return new ResponseEntity<>(student, HttpStatus.CREATED);
    }

}
