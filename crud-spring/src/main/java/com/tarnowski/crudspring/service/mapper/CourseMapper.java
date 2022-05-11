package com.tarnowski.crudspring.service.mapper;

import com.tarnowski.crudspring.model.Course;
import com.tarnowski.crudspring.service.dto.CourseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CourseMapper {

    @Mapping(target = "id", source = "id")
    CourseDTO toDto(Course entity);

    Course toEntity(CourseDTO courseDTO);


}
