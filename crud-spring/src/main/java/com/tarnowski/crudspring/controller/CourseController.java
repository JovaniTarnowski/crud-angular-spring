package com.tarnowski.crudspring.controller;

import com.tarnowski.crudspring.exception.ResourceNotFoundException;
import com.tarnowski.crudspring.service.CourseService;
import com.tarnowski.crudspring.service.dto.CourseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/courses")
@RequiredArgsConstructor
public class CourseController {

    private final CourseService courseService;

    @GetMapping
    public ResponseEntity<Page<CourseDTO>> listAllCourses(Pageable pageable) {
        Page<CourseDTO> course = courseService.listAllCourses(pageable);
        return new ResponseEntity<>(course, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CourseDTO> findCourseById(@PathVariable(value = "id") Long id){
        CourseDTO course = courseService.findById(id);
        return new ResponseEntity<>(course, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CourseDTO> createCourse(@RequestBody CourseDTO courseDto) {
        CourseDTO course =  courseService.save(courseDto);
        return new ResponseEntity<>(course, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public void deleteCourse(@PathVariable(value = "id") Long id) throws ResourceNotFoundException {
        courseService.deleteCourse(id);
    }

    @PutMapping
    public ResponseEntity<CourseDTO> updateCourse(@RequestBody CourseDTO courseDTO) throws ResourceNotFoundException {
        CourseDTO course =  courseService.save(courseDTO);
        return new ResponseEntity<>(course, HttpStatus.OK);
    }


}
