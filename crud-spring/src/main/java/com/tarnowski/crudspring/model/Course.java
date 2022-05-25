package com.tarnowski.crudspring.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
@Getter
@Setter
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(length = 200, nullable = false)
    @NotBlank(message = "Name is mandatory")
    private String name;

    @Column(length = 10, nullable = false)
    @NotBlank(message = "Category is mandatory")
    private String category;

}
