package com.vn.devmaster.services.mapper;

import com.vn.devmaster.services.dto.StudentDTO;
import com.vn.devmaster.services.entites.Student;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class StudentMapper implements EntityMapper<Student, StudentDTO> {
    private final ClazzMapper clazzMapper;

    public StudentMapper(ClazzMapper clazzMapper) {
        this.clazzMapper = clazzMapper;
    }

    @Override
    public Student toEntity(StudentDTO dto) {
        return Student
                .builder()
                .id(dto.getId())
                .address(dto.getAddress())
                .firstName(dto.getFirstName())
                .lastName(dto.getLastName())
                .clazz(clazzMapper.toEntity(dto.getClazz()))
                .build();
    }

    @Override
    public StudentDTO toDto(Student entity) {
        return StudentDTO
                .builder()
                .id(entity.getId())
                .address(entity.getAddress())
                .firstName(entity.getFirstName())
                .lastName(entity.getLastName())
                .clazz(clazzMapper.toDto(entity.getClazz()))
                .build();
    }

    @Override
    public List<Student> toEntity(List<StudentDTO> dto) {
        return null;
    }

    @Override
    public List<StudentDTO> toDto(List<Student> entity) {
        List<StudentDTO> dtos = new ArrayList<>();
        entity.forEach(student -> {
            StudentDTO studentDTO = toDto(student);
            dtos.add(studentDTO);
        });
        return dtos;
    }
}
