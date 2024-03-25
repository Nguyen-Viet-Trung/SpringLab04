package com.vn.devmaster.services.repository;

import com.vn.devmaster.services.entites.Clazz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClazzRepository extends JpaRepository<Clazz, Integer> {
}