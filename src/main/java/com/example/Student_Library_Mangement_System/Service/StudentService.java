package com.example.Student_Library_Mangement_System.Service;

import com.example.Student_Library_Mangement_System.DTOs.StudentMobRequestDto;
import com.example.Student_Library_Mangement_System.Enums.CardStatus;
import com.example.Student_Library_Mangement_System.Models.Card;
import com.example.Student_Library_Mangement_System.Models.Student;
import com.example.Student_Library_Mangement_System.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

@Service
public class StudentService {


    @Autowired
    StudentRepository studentRepository;
    @PostMapping("/add")
    public String createStudent(Student student){

        Card card= new Card();
        card.setCardStatus(CardStatus.ACTIVATED);
        card.setStudent(student);

        // let's go the student
        student.setCard(card);

        studentRepository.save(student);
        return "Student and card are added";
    }
    public String findNameByEmail(String email){
      Student student=studentRepository.findByEmail(email);
      return student.getName();
    }
    public String updateMobNo(StudentMobRequestDto studentMobRequestDto){

        //Convert the Dto into entity so that it can be saved better

        //first we will try to fetch the original data
        Student originalStudent=studentRepository.findById(studentMobRequestDto.getId()).get();
        //we will keep the other parameter as it is but will the required attributes
        originalStudent.setMobNo(studentMobRequestDto.getMobNo());
        // always the entity object is being saved
        studentRepository.save(originalStudent);
        return "Student has been saved successfully";
    }
}
