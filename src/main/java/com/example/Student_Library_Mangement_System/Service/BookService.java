package com.example.Student_Library_Mangement_System.Service;

import com.example.Student_Library_Mangement_System.DTOs.BookRequestDto;
import com.example.Student_Library_Mangement_System.Models.Author;
import com.example.Student_Library_Mangement_System.Models.Book;
import com.example.Student_Library_Mangement_System.Repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    AuthorRepository authorRepository;
    public String addBook(BookRequestDto bookRequestDto){
        //want to get author id
        int AuthorId= bookRequestDto.getAuthorId();
        //now i will fetching the author entity

        Author author = authorRepository.findById(AuthorId).get();

        //we have create this entity so that we save it into DB
         Book book= new Book();
         book.setGenre(bookRequestDto.getGenre());
         book.setIssued(false);
         book.setName(bookRequestDto.getName());
         book.setPages(bookRequestDto.getPages());





        book.setAuthor(author);

        //now we have to update the books written in the parent class


        List<Book>currentBookWritten= author.getBookWritten();
        currentBookWritten.add(book);
        author.setBookWritten(currentBookWritten);


        // now the book has to be saved but also author to be saved'
        //why do we need to  again save the author?? bcz the author Entity has been updated..we need to save it
        authorRepository.save(author);// data is modified thqta why we need to update it
        // we dont need bookRep.save bcz it will autocall by cascading effect
        return "book added succesfully";

    }
}
