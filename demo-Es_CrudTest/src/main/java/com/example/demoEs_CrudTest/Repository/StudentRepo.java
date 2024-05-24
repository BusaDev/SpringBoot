package com.example.demoEs_CrudTest.Repository;

import com.example.demoEs_CrudTest.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepo extends JpaRepository<Student, Long> {
}
