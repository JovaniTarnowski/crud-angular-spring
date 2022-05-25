package com.tarnowski.crudspring.service.mapper;


import com.tarnowski.crudspring.model.Student;
import com.tarnowski.crudspring.service.dto.StudentDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface StudentMapper {

    @Mapping(target = "courseId", source = "course.id")
    @Mapping(target = "courseName", source = "course.name")
    StudentDTO toDto(Student id);

    List<StudentDTO> toDto(List<Student> id);

    @Mapping(target = "course.id", source = "courseId")
    Student toEntity(StudentDTO studentDTO);
}
