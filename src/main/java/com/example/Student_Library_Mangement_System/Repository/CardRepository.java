package com.example.Student_Library_Mangement_System.Repository;

import com.example.Student_Library_Mangement_System.Models.Card;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepository extends JpaRepository<Card,Integer> {
}
