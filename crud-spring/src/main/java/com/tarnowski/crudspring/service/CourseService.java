package com.tarnowski.crudspring.service;

import com.tarnowski.crudspring.exception.ResourceNotFoundException;
import com.tarnowski.crudspring.model.Course;
import com.tarnowski.crudspring.repository.CourseRepository;
import com.tarnowski.crudspring.service.dto.CourseDTO;
import com.tarnowski.crudspring.service.mapper.CourseMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
@RequiredArgsConstructor
public class CourseService {

    private final CourseRepository courseRepository;

    private final CourseMapper courseMapper;

    public CourseDTO findById(Long id){
        Course course = courseRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Course not found :: " + id));
        return courseMapper.toDto(course);
    }

    public Page<CourseDTO> listAllCourses(Pageable pageable){
        return courseRepository.findAll(pageable).map(courseMapper::toDto);
    }

    public CourseDTO save(CourseDTO courseDTO){
        Course course = courseMapper.toEntity(courseDTO);
        Course courseSaved = courseRepository.save(course);
        return courseMapper.toDto(courseSaved);
    }

    public void deleteCourse(Long id){
        courseRepository.deleteById(id);
    }

}
