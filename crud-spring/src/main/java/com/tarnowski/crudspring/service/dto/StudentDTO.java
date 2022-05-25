package com.tarnowski.crudspring.service.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class StudentDTO {

    private Long id;

    @NotNull
    private String name;

    @NotNull
    private String email;

    @NotNull
    private Long courseId;

    private String courseName;

}
