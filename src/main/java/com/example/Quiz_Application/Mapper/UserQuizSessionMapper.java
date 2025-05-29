package com.example.Quiz_Application.Mapper;

import com.example.Quiz_Application.DTO.UserQuizSessionDTO;
import com.example.Quiz_Application.Model.UserInformation;
import com.example.Quiz_Application.Model.UserQuizSession;

public class UserQuizSessionMapper {

    public static UserQuizSessionDTO toDTO(UserQuizSession session) {

        UserQuizSessionDTO dto = new UserQuizSessionDTO();

        dto.setSessionId(session.getSessionId());
        dto.setUserId(session.getUser().getUserId());
        dto.setStartTime(session.getStartTime());
        dto.setEndTime(session.getEndTime());
        dto.setStatus(session.getStatus().name());

        return dto;
    }

    public static UserQuizSession toEntity(UserQuizSessionDTO dto) {

        UserQuizSession session = new UserQuizSession();

        session.setSessionId(dto.getSessionId());
        //session.setUser(null);

        UserInformation user = new UserInformation();
        user.setUserId(dto.getUserId());
        session.setUser(user);

        session.setStartTime(dto.getStartTime());
        session.setEndTime(dto.getEndTime());
        session.setStatus(UserQuizSession.Status.valueOf(dto.getStatus()));

        return session;
    }
}
