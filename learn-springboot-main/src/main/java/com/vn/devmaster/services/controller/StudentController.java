package com.vn.devmaster.services.controller;


import com.vn.devmaster.services.dto.StudentDTO;
import com.vn.devmaster.services.entites.Student;
import com.vn.devmaster.services.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("student/v1")
public class StudentController {
    @Autowired
    private StudentService studentService;


    @GetMapping("")
    List<Student> findAll() {
        return studentService.findAll();
    }

    @GetMapping("/find-by-address")
    List<StudentDTO> findByAddress(@RequestParam("address") String address) {
        return studentService.findByAddress(address);
    }

    @PostMapping("")
    String save(@RequestBody StudentDTO student) {
        String message = studentService.save(student);
        return message;
    }

    @PutMapping("")
    String update(@RequestParam("id") int id, @RequestBody StudentDTO studentDTO) {
        String message = studentService.update(id, studentDTO);
        return message;
    }
    @DeleteMapping("")
    String delete(@RequestParam("id") int id) {
        String message = studentService.delete(id);
        return message;
    }
}
