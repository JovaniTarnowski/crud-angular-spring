package com.tarnowski.crudspring.service;

import com.tarnowski.crudspring.model.Student;
import com.tarnowski.crudspring.repository.StudentRepository;
import com.tarnowski.crudspring.service.dto.StudentDTO;
import com.tarnowski.crudspring.service.mapper.StudentMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    private final StudentMapper studentMapper;

    public List<StudentDTO> listAllStudents(Long id){
        return studentMapper.toDto(studentRepository.findAllByCourseId(id));
    }

    public StudentDTO save(StudentDTO studentDTO) {
        Student studentSaved = studentMapper.toEntity(studentDTO);
        return studentMapper.toDto(studentRepository.save(studentSaved));
    }
}
