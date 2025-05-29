package com.example.Quiz_Application.Mapper;

import com.example.Quiz_Application.DTO.RandomQuestionDTO;
import com.example.Quiz_Application.Model.Question;

public class RandomQuestionMapper
{
    public static RandomQuestionDTO toDTO(Question question) {

        RandomQuestionDTO dto = new RandomQuestionDTO();

        dto.setQuestionId(question.getQuestionId());
        dto.setQuestion(question.getQuestion());
        dto.setOptionA(question.getOptionA());
        dto.setOptionB(question.getOptionB());
        dto.setOptionC(question.getOptionC());
        dto.setOptionD(question.getOptionD());

        return dto;
    }
}
