package com.example.Student_Library_Mangement_System.Repository;

import com.example.Student_Library_Mangement_System.Models.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository  extends JpaRepository<Student,Integer> {
    Student findByEmail(String email);
    List<Student> findByCountry(String country);
}
