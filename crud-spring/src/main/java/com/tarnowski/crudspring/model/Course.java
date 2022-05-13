package com.tarnowski.crudspring.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity(name = "course")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 200, nullable = false)
    private String name;

    @Column(length = 10, nullable = false)
    private String category;

}
