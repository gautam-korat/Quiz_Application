package com.example.Quiz_Application.Mapper;

import com.example.Quiz_Application.DTO.QuestionDTO;
import com.example.Quiz_Application.Model.Question;

public class QuestionMapper {

    public static QuestionDTO toDTO(Question question) {

        QuestionDTO dto = new QuestionDTO();

        dto.setQuestionId(question.getQuestionId());
        dto.setQuestion(question.getQuestion());
        dto.setOptionA(question.getOptionA());
        dto.setOptionB(question.getOptionB());
        dto.setOptionC(question.getOptionC());
        dto.setOptionD(question.getOptionD());
        dto.setCorrectOption(question.getCorrectOption());

        return dto;
    }

    public static Question toEntity(QuestionDTO dto) {

        Question question = new Question();

        question.setQuestionId(dto.getQuestionId());
        question.setQuestion(dto.getQuestion());
        question.setOptionA(dto.getOptionA());
        question.setOptionB(dto.getOptionB());
        question.setOptionC(dto.getOptionC());
        question.setOptionD(dto.getOptionD());
        question.setCorrectOption(dto.getCorrectOption());

        return question;
    }
}
