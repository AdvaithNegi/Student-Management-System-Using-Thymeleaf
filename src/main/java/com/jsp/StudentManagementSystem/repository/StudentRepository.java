package com.jsp.StudentManagementSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.StudentManagementSystem.dto.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}
