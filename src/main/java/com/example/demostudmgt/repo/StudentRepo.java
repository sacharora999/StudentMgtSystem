package com.example.demostudmgt.repo;

import com.example.demostudmgt.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo extends JpaRepository<Student, Long> {
}
