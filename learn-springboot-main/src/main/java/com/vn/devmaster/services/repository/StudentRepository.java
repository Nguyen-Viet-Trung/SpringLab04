package com.vn.devmaster.services.repository;

import com.vn.devmaster.services.entites.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface  StudentRepository extends JpaRepository<Student, Integer> {

    //HQL
//    @Query(value = "select s from Student s where s.address like concat('%',:address,'%')")
//    List<Student> findByAddress(@Param("address") String address);

    //nativate query
    @Query(value = "select * from student where address like concat('%', :address, '%')", nativeQuery = true)
    List<Student> findByAddress(@Param("address") String address);

    List<Student> findAllByAddress(String address);
    
    @Modifying
    @Query(value = "delete from student where id = :id", nativeQuery = true)
    int deleteStudent(@Param("id") int id);
}
