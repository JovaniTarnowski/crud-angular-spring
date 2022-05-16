package com.tarnowski.crudspring.service.mapper;

import com.tarnowski.crudspring.model.Course;
import com.tarnowski.crudspring.service.dto.CourseDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CourseMapper {

    CourseDTO toDto(Course entity);

    Course toEntity(CourseDTO courseDTO);

}
