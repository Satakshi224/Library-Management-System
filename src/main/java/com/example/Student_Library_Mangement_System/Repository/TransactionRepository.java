package com.example.Student_Library_Mangement_System.Repository;

import com.example.Student_Library_Mangement_System.Models.Transactions;
import jakarta.transaction.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository  extends JpaRepository<Transactions,Integer> {

}
