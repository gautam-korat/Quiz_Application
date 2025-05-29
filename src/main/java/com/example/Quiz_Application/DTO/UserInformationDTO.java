package com.example.Quiz_Application.DTO;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserInformationDTO
{
    private Long userId;
    private String userName;
    private String userEmail;
    private String message;

    // default Constructor

    public UserInformationDTO()
    {

    }

    // parameterized constructor
    public UserInformationDTO(Long userId, String userName, String userEmail)
    {
        this.userId = userId;
        this.userName = userName;
        this.userEmail = userEmail;
    }

    // parameterized Constructor for message
    public UserInformationDTO(String message)
    {
        this.message = message;
    }

    // send only message for user
    public static UserInformationDTO onlyMessage(String message)
    {
        return new UserInformationDTO(message);
    }

    // getter setter
    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}