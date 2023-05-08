package com.example.Student_Library_Mangement_System.Service;

import com.example.Student_Library_Mangement_System.DTOs.AuthorEntryDto;
import com.example.Student_Library_Mangement_System.Models.Author;
import com.example.Student_Library_Mangement_System.Repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {
    @Autowired
    AuthorRepository authorRepository;

    public String createAuthor(AuthorEntryDto authorEntryDto){
       // important step is : in the params:the object i of the DTO but the repository only interact with entities
        //Solution convert authorEntryDto--->author

        //created an author object
        Author author= new Author();
        // setting its attribute so that we can save correct value in DB
        author.setName(authorEntryDto.getName());
        author.setAge(authorEntryDto.getAge());
        author.setCountry(authorEntryDto.getCountry());
        author.setRating(authorEntryDto.getRating());
        authorRepository.save(author);
        return "Author added successfully";

    }

}
