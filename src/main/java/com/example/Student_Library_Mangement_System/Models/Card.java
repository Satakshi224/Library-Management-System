package com.example.Student_Library_Mangement_System.Models;

import com.example.Student_Library_Mangement_System.Enums.CardStatus;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="Card")
public class Card  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @CreationTimestamp
    private  Date createdOn;

    @UpdateTimestamp
   private  Date UpdatedOn;

    @Enumerated(value = EnumType.STRING)
    private CardStatus cardStatus;


    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @OneToOne
    @JoinColumn
    private  Student student;  ///Child class unidirectional mapping

    // card is parent w.r.t  book
    @OneToMany(mappedBy = "card",cascade = CascadeType.ALL)
    List<Book>BookIssued= new ArrayList<>();

    //Connecting card class to the transaction
    @OneToMany(mappedBy = "card",cascade = CascadeType.ALL)
    private List<Transactions> transactionsList= new ArrayList<>();

    public List<Book> getBookIssued() {
        return BookIssued;
    }

    public void setBookIssued(List<Book> bookIssued) {
        BookIssued = bookIssued;
    }

    public List<Transactions> getTransactionsList() {
        return transactionsList;
    }

    public void setTransactionsList(List<Transactions> transactionsList) {
        this.transactionsList = transactionsList;
    }

    public Card() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public Date getUpdatedOn() {
        return UpdatedOn;
    }

    public void setUpdatedOn(Date updatedOn) {
        UpdatedOn = updatedOn;
    }

    public CardStatus getCardStatus() {
        return cardStatus;
    }

    public void setCardStatus(CardStatus cardStatus) {
        this.cardStatus = cardStatus;
    }
}
