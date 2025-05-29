package com.example.Quiz_Application.Mapper;

import com.example.Quiz_Application.Model.Question;
import com.example.Quiz_Application.Model.UserAnswer;
import com.example.Quiz_Application.DTO.UserAnswerDTO;
import com.example.Quiz_Application.Model.UserInformation;
import com.example.Quiz_Application.Model.UserQuizSession;

public class UserAnswerMapper {

    public static UserAnswerDTO toDTO(UserAnswer answer) {

        UserAnswerDTO dto = new UserAnswerDTO();

        dto.setAnswerId(answer.getAnswerId());
        dto.setUserId(answer.getUser().getUserId());
        dto.setQuestionId(answer.getQuestion().getQuestionId());
        dto.setAnswer(answer.getAnswer());

        return dto;
    }

    public static UserAnswer toEntity(UserAnswerDTO dto) {

        UserAnswer answer = new UserAnswer();

        answer.setAnswerId(dto.getAnswerId());

        UserInformation user = new UserInformation();
        user.setUserId(dto.getUserId());
        answer.setUser(user);

        UserQuizSession session = new UserQuizSession();
        answer.setSession(session);

        Question question = new Question();
        question.setQuestionId(dto.getQuestionId());
        answer.setQuestion(question);

        answer.setAnswer(dto.getAnswer());

        return answer;
    }
}