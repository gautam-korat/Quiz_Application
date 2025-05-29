package com.example.Quiz_Application.Controller;

import com.example.Quiz_Application.DTO.QuizResultDTO;
import com.example.Quiz_Application.DTO.RandomQuestionDTO;
import com.example.Quiz_Application.DTO.UserAnswerDTO;
import com.example.Quiz_Application.DTO.UserInformationDTO;
import com.example.Quiz_Application.Model.UserInformation;
import com.example.Quiz_Application.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController
{
    @Autowired
    private UserService userService;

    @PostMapping("/user-registration") // http://localhost:8080/user/user-registration
    public ResponseEntity<UserInformationDTO> userRegistration(@RequestBody UserInformation user)
    {
        return ResponseEntity.ok(userService.userRegistration(user));
    }

    @PostMapping("/start-quiz/{userId}") // http://localhost:8080/user/start-quiz/1
    public ResponseEntity<String> startQuiz(@PathVariable Long userId)
    {
        return userService.startQuiz(userId);
    }

    @PostMapping("/get-random-question/{userId}") // http://localhost:8080/user/get-random-question/1
    public ResponseEntity<RandomQuestionDTO> getRandomQuestion(@PathVariable Long userId ,@RequestBody List<Long> askQuestionId)
    {
        return userService.getRandomQuestion(userId,askQuestionId);
    }

    @PostMapping("/submit-answer/{userId}") // http://localhost:8080/user/submit-answer/1
    public ResponseEntity<String> submitAnswer(@PathVariable Long userId, @RequestBody UserAnswerDTO answerDTO)
    {
        return userService.submitAnswer(userId,answerDTO);
    }

    @GetMapping("/get-quiz-result/{userId}") // http://localhost:8080/user/get-quiz-result/1
    public ResponseEntity<QuizResultDTO> getQuizResult(@PathVariable Long userId)
    {
        return userService.getQuizResult(userId);
    }
}