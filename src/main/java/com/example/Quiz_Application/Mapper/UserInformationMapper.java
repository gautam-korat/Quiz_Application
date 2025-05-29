package com.example.Quiz_Application.Mapper;

import com.example.Quiz_Application.DTO.UserInformationDTO;
import com.example.Quiz_Application.Model.UserInformation;

public class UserInformationMapper {

    public static UserInformationDTO toDTO(UserInformation user) {

        UserInformationDTO dto = new UserInformationDTO();

        dto.setUserId(user.getUserId());
        dto.setUserName(user.getUserName());
        dto.setUserEmail(user.getUserEmail());
        return dto;
    }

    public static UserInformation toEntity(UserInformationDTO dto) {

        UserInformation user = new UserInformation();

        user.setUserId(dto.getUserId());
        user.setUserName(dto.getUserName());
        user.setUserEmail(dto.getUserEmail());
        return user;
    }
}