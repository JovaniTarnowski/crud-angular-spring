package com.tarnowski.crudspring.service.dto;

import com.tarnowski.crudspring.model.Student;
import lombok.Data;

@Data
public class CourseDTO {

    private Long id;

    private String name;

    private String category;

}
