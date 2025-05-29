package com.example.Quiz_Application.Service;

import com.example.Quiz_Application.DTO.QuestionDTO;
import com.example.Quiz_Application.Mapper.QuestionMapper;
import com.example.Quiz_Application.Model.Question;
import com.example.Quiz_Application.Repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class QuestionService
{
    @Autowired
    private QuestionRepository questionRepository;

    public QuestionDTO addQuestion(Question question)
    {
        try
        {
            if(questionRepository.existsByQuestion(question.getQuestion()))
            {
                return QuestionDTO.onlyMessage("⚠\uFE0F This question already exists!");
            }

            Question savedQuestion = questionRepository.save(question);
            QuestionDTO dto = QuestionMapper.toDTO(savedQuestion);
            dto.setMessage("✅ Question Added Successfully!");
            return dto;
        }
        catch (Exception e)
        {
            System.out.println("❌ Failed to Add Question. Please try again!" + e);
            return QuestionDTO.onlyMessage("❌ Failed to Add Question. Please try again!");
        }
    }
}