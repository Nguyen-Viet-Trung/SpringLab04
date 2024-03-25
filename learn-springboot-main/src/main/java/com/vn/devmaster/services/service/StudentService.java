package com.vn.devmaster.services.service;

import com.vn.devmaster.services.dto.StudentDTO;
import com.vn.devmaster.services.entites.Clazz;
import com.vn.devmaster.services.entites.Student;
import com.vn.devmaster.services.mapper.ClazzMapper;
import com.vn.devmaster.services.mapper.StudentMapper;
import com.vn.devmaster.services.repository.ClazzRepository;
import com.vn.devmaster.services.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;
    private final ClazzMapper clazzMapper;
    private final ClazzRepository clazzRepository;

    public List<Student> findAll() {
        List<Student> students = studentRepository.findAll();
        return students;
    }

    public List<StudentDTO> findByAddress(String address) {
        List<Student> students = studentRepository.findByAddress(address);
        return studentMapper.toDto(students);
    }

    public Student findById(int id) {
        Optional<Student> optionalStudent = studentRepository.findById(id);
        if (optionalStudent.isEmpty()) {
            System.out.println("Không tìm thấy sinh viên");
            return null;
        }
        return optionalStudent.get();
    }

    @Transactional
    public String save(StudentDTO studentDTO) {
        Clazz clazz = clazzMapper.toEntity(studentDTO.getClazz());
        clazz = clazzRepository.save(clazz);

        Student student = studentMapper.toEntity(studentDTO);
        student.setClazz(clazz);
        studentRepository.save(student);
        return "Thêm thành công";
    }

    public String update(int id, StudentDTO studentDTO) {
        boolean existsStudent = studentRepository.existsById(id);
//        Clazz clazz = clazzRepository.findById(studentDTO.getClazz().getId());
        if (!existsStudent) return "Không có sinh viên có id = " + id;
        Student student = new Student();
        Clazz clazz = new Clazz();
        student.setId(id);
        student.setFirstName(studentDTO.getFirstName());
        student.setLastName(studentDTO.getLastName());
        student.setAddress(studentDTO.getAddress());
        clazz = clazzMapper.toEntity(studentDTO.getClazz());
        student.setClazz(clazz);
        studentRepository.save(student);
        return "cập nhật thành công";
    }
    @Transactional
    public String delete(int id){
        boolean existsStudent = studentRepository.existsById(id);
        if(existsStudent == false) return "Không có sinh viên có id = " + id;
        studentRepository.deleteStudent(id);
        return "Đã xóa thành công";
    }    
}
