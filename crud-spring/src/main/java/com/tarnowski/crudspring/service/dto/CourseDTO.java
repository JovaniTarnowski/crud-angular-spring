package com.tarnowski.crudspring.service.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Getter
@Setter
public class CourseDTO implements Serializable {

    private Long id;

    @NotNull
    private String name;

    @NotNull
    private String category;

}
