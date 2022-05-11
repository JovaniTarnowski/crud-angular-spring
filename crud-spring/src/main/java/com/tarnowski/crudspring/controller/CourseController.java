package com.tarnowski.crudspring.controller;

import com.tarnowski.crudspring.exception.ResourceNotFoundException;
import com.tarnowski.crudspring.service.CourseService;
import com.tarnowski.crudspring.service.dto.CourseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/courses")
@RequiredArgsConstructor
public class CourseController {

    private final CourseService courseService;

    @GetMapping
    public @ResponseBody Page<CourseDTO> listAllCourses(Pageable pageable) {
        return courseService.listAllCourses(pageable);
    }

    @GetMapping("/{id}")
    public CourseDTO findCourseById(@PathVariable(value = "id") Long id){
        return courseService.findById(id);
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public CourseDTO createCourse(@RequestBody CourseDTO courseDto) {
        return courseService.createCourse(courseDto);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCourse(@PathVariable(value = "id") Long id) throws ResourceNotFoundException {
        courseService.deleteCourse(id);
    }

    @PutMapping("/update")
    public CourseDTO updateCourse(@RequestBody CourseDTO courseDTO) throws ResourceNotFoundException {
        return courseService.updateCourse(courseDTO);
    }


}
