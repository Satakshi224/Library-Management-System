package com.example.Student_Library_Mangement_System.Controller;

import com.example.Student_Library_Mangement_System.DTOs.AuthorEntryDto;
import com.example.Student_Library_Mangement_System.Models.Author;
import com.example.Student_Library_Mangement_System.Service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/author")
public class AuthorController {

    @Autowired
    AuthorService authorService;

    @PostMapping("/add")
    public String addAuthor(@RequestBody AuthorEntryDto authorEntryDto){
      return authorService.createAuthor(authorEntryDto);
    }

}
