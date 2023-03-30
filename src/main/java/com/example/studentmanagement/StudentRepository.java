package com.example.studentmanagement;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {
    @Override
    Optional<Student> findById(Long id);

    @Override
    void deleteById(Long id);

    Optional<Student> findByEmail(String email);
}
