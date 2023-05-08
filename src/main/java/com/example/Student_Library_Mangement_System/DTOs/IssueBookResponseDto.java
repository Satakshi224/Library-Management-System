package com.example.Student_Library_Mangement_System.DTOs;

import org.springframework.transaction.TransactionStatus;

public class IssueBookResponseDto {

    private String transactionId;
    private  String bookName;

    private TransactionStatus transactionStatus;

}
