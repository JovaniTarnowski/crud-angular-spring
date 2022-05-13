package com.tarnowski.crudspring.service.dto;

import com.tarnowski.crudspring.model.Course;
import lombok.Data;

@Data
public class StudentDTO {

    private Long id;

    private String name;

    private String email;

    private Long courseId;

    private String courseName;

}
