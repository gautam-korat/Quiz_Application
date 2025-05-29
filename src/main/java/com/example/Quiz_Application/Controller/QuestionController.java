package com.example.Quiz_Application.Controller;

import com.example.Quiz_Application.DTO.QuestionDTO;
import com.example.Quiz_Application.Model.Question;
import com.example.Quiz_Application.Service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/question")
public class QuestionController
{
    @Autowired
    QuestionService questionService;

    @PostMapping("/add-question") // http://localhost:8080/question/add-question
    public ResponseEntity<QuestionDTO> addQuestion (@RequestBody Question question)
    {
        return ResponseEntity.ok(questionService.addQuestion(question));
    }
}