package com.example.Student_Library_Mangement_System.Service;

import com.example.Student_Library_Mangement_System.DTOs.IssueBookRequestDto;
import com.example.Student_Library_Mangement_System.Enums.CardStatus;
import com.example.Student_Library_Mangement_System.Enums.TransactionStatus;
import com.example.Student_Library_Mangement_System.Models.Book;
import com.example.Student_Library_Mangement_System.Models.Card;
import com.example.Student_Library_Mangement_System.Models.Transactions;
import com.example.Student_Library_Mangement_System.Repository.BookRepository;
import com.example.Student_Library_Mangement_System.Repository.CardRepository;
import com.example.Student_Library_Mangement_System.Repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TransactionService {
    @Autowired
    TransactionRepository transactionRepository;

    @Autowired
    BookRepository bookRepository;
    @Autowired
    CardRepository cardRepository;
     public String issueBook(IssueBookRequestDto issueBookRequestDto)throws Exception{
         int bookId=issueBookRequestDto.getBookId();
         int cardId=issueBookRequestDto.getCardId();
         // getting the book entity and card entity ?? why do we really need this
         //we are doing this bcz we want to set the transaction attribute..

         Book book =bookRepository.findById(bookId).get();
         Card card=cardRepository.findById(cardId).get();
         // final goal is to make a transaction entity and save it..
         Transactions transaction=new Transactions();
         //setting the attribute
         transaction.setBook(book);
         transaction.setCard(card);
         transaction.setTransactionId(UUID.randomUUID().toString());
         transaction.setIssueOperation(true);
       //  transaction.setTransactionStatus(TransactionStatus.PENDING);

         //attribute left is success /failure
         //check for validation
        if(book==null || book.isIssued()==true){
            transaction.setTransactionStatus(TransactionStatus.FAILED);
            transactionRepository.save(transaction);
            throw new Exception("Book is not Available");
        }
        if(card==null || (card.getCardStatus()!=CardStatus.ACTIVATED)) {
            transactionRepository.save(transaction);
            transaction.setTransactionStatus(TransactionStatus.FAILED);
            throw new Exception("card is not valid");
        }
        transaction.setTransactionStatus(TransactionStatus.SUCCESS);
        // set book attribute
         book.setIssued(true);
         List<Transactions> listOfTransactionForBook=book.getListOfTransactions();
         listOfTransactionForBook.add(transaction);
         //between the book and transaction:bidirectional
         book.setListOfTransactions(listOfTransactionForBook);

         // I need to make changes in the card
         //book and the card
         List<Book>issuedBookForCard=card.getBookIssued();
         issuedBookForCard.add(book);
         card.setBookIssued(issuedBookForCard);

         // card and the transaction:bidirectional(parent class)
         List<Transactions> transactionsListForCard=card.getTransactionsList();
         transactionsListForCard.add(transaction);
         card.setTransactionsList(transactionsListForCard);
         cardRepository.save(card);

         // automatically by cascading:book and transaction will be saved.
         //saving the parent
       return "Book issued Successfully";

     }

}
