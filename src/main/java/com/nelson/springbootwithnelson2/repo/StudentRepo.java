package com.nelson.springbootwithnelson2.repo;

import com.nelson.springbootwithnelson2.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface StudentRepo extends JpaRepository<Student, Integer> {
    Optional<Student> findStudentByEmail(String email);
}
