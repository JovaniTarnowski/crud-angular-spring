package com.tarnowski.crudspring.service;

import com.tarnowski.crudspring.exception.ResourceNotFoundException;
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
        return courseMapper.toDto(courseRepository.findById(id)
                                .orElseThrow(() -> new ResourceNotFoundException("Course not found :: " + id)));
    }

    public Page<CourseDTO> listAllCourses(Pageable pageable){
        return courseRepository.findAll(pageable).map(courseMapper::toDto);
    }

    public CourseDTO createCourse(CourseDTO courseDTO){
        return courseMapper.toDto(courseRepository.save(courseMapper.toEntity(courseDTO)));
    }

    public void deleteCourse(Long id){
        courseRepository.deleteById(id);
    }

    public CourseDTO updateCourse(CourseDTO courseDTO){
        return courseMapper.toDto(courseRepository.save(courseMapper.toEntity(courseDTO)));
    }

}
