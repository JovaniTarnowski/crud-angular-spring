package com.tarnowski.crudspring.service.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class CourseDTO implements Serializable {

    private Long id;

    private String name;

    private String category;

}
