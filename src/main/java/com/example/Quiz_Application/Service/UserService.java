package com.example.Quiz_Application.Service;

import com.example.Quiz_Application.DTO.QuizResultDTO;
import com.example.Quiz_Application.DTO.RandomQuestionDTO;
import com.example.Quiz_Application.DTO.UserAnswerDTO;
import com.example.Quiz_Application.DTO.UserInformationDTO;
import com.example.Quiz_Application.Mapper.RandomQuestionMapper;
import com.example.Quiz_Application.Mapper.UserInformationMapper;
import com.example.Quiz_Application.Model.Question;
import com.example.Quiz_Application.Model.UserAnswer;
import com.example.Quiz_Application.Model.UserInformation;
import com.example.Quiz_Application.Model.UserQuizSession;
import com.example.Quiz_Application.Repository.QuestionRepository;
import com.example.Quiz_Application.Repository.UserAnswerRepository;
import com.example.Quiz_Application.Repository.UserInformationRepository;
import com.example.Quiz_Application.Repository.UserQuizSessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class UserService
{
    @Autowired
    private UserInformationRepository userRepository;

    @Autowired
    private UserQuizSessionRepository userQuizSessionRepository;

    @Autowired
    QuestionRepository questionRepository;

    @Autowired
    UserAnswerRepository userAnswerRepository;

    public UserInformationDTO userRegistration(UserInformation user)
    {
        try
        {
           if(userRepository.existsByUserEmail(user.getUserEmail()))
           {
                return UserInformationDTO.onlyMessage("⚠\uFE0F This Email is Already Registered!");
           }
           UserInformation userRegister = userRepository.save(user);
           UserInformationDTO dto = UserInformationMapper.toDTO(userRegister);
           dto.setMessage("✅User Registered Successfully");
           return dto;
        }
        catch (Exception e)
        {
            System.out.println("❌ Failed To User Registration. Please try again!" + e);
            return UserInformationDTO.onlyMessage("❌ Failed To User Registration . Please try again!");
        }
    }

    public ResponseEntity<String> startQuiz(Long userId)
    {
        Optional<UserInformation> userInformation = userRepository.findById(userId);

        if(userInformation.isEmpty())
        {
            return ResponseEntity.ok("❌ User Not Found");
        }

        UserInformation user = userInformation.get();

        Optional<UserQuizSession> activeQuiz = userQuizSessionRepository.findLatestActiveSession(userId);

        if(activeQuiz.isPresent())
        {
            return ResponseEntity.ok("Your Quiz is Already Active");
        }

        UserQuizSession session = new UserQuizSession();
        session.setUser(user);
        session.setStartTime(LocalDateTime.now());
        session.setStatus(UserQuizSession.Status.ACTIVE);

        userQuizSessionRepository.save(session);

        return ResponseEntity.ok(" ✅ New Quiz Started");
    }

    public ResponseEntity<RandomQuestionDTO> getRandomQuestion(Long userId,List<Long> askQuestion)
    {
        if(!userRepository.existsById(userId))
        {
            return ResponseEntity.ok(RandomQuestionDTO.message("User Not Found"));
        }

        if (askQuestion.size() >= 5)
        {
            return ResponseEntity.ok(RandomQuestionDTO.message("🎉 Quiz Completed!"));
        }

        // 5 Random Question Fetch
        List<Question> randomQuestion = questionRepository.findRandomQuestion();

        for (Question question : randomQuestion)
        {
            if (!askQuestion.contains(question.getQuestionId()))
            {
                askQuestion.add(question.getQuestionId());
                return ResponseEntity.ok(RandomQuestionMapper.toDTO(question));
            }
        }
        return ResponseEntity.ok(RandomQuestionDTO.message("🎉 Quiz Completed!"));
    }

    @Transactional
    public ResponseEntity<String> submitAnswer(Long userId, UserAnswerDTO userAnswerDTO)
    {
        Optional<UserQuizSession> findActiveQuiz = userQuizSessionRepository.findLatestActiveSession(userId);

        if (findActiveQuiz.isEmpty())
        {
            return ResponseEntity.ok("No Quiz Found! Please Start Quiz");
        }

        // find Active User
        UserQuizSession activeUser = findActiveQuiz.get();
        UserInformation user = activeUser.getUser();

        // find Question
        Optional<Question> findQuestion = questionRepository.findById(userAnswerDTO.getQuestionId());
        if (findQuestion.isEmpty())
        {
            return ResponseEntity.ok("❌ Question Not Found!");
        }

        Question question = findQuestion.get();

        // Check if Answer Already Submitted or Not
        boolean isAlreadySubmitted = userAnswerRepository.answerAlreadySubmitted(user, activeUser, question);

        if (isAlreadySubmitted)
        {
            return ResponseEntity.ok("Answer Already Submitted for this Question!");
        }

        // Save User Answer
        UserAnswer userAnswer = new UserAnswer();

        userAnswer.setUser(user);
        userAnswer.setSession(activeUser);
        userAnswer.setQuestion(question);
        userAnswer.setAnswer(userAnswerDTO.getAnswer());

        userAnswerRepository.save(userAnswer);

        String result;
        if (question.getCorrectOption() == userAnswerDTO.getAnswer())
        {
            result = "✅ Correct Answer!";
        }
        else
        {
            result = "❌ Wrong Answer!";
        }

        // check if User 5 Answer is submitted
        int countAnswer = userAnswerRepository.countBySession(activeUser);

        if (countAnswer >= 5)
        {
            activeUser.setStatus(UserQuizSession.Status.COMPLETE);
            activeUser.setEndTime(LocalDateTime.now());

            userQuizSessionRepository.save(activeUser);

            return ResponseEntity.ok(result + " Quiz Completed! ");
        }
        return ResponseEntity.ok(result);
    }

    public ResponseEntity<QuizResultDTO> getQuizResult(Long userId) {

        // Find Latest Complete Quiz for the User
        Optional<UserQuizSession> completedSessionOpt = userQuizSessionRepository.findLatestCompletedSession(userId);

        if (completedSessionOpt.isEmpty())
        {
            return ResponseEntity.status(404).body(new QuizResultDTO(0, 0, 0, "❌ No Completed Quiz Found for this User!"));
        }

        UserQuizSession completedSession = completedSessionOpt.get();

        // Get All Answer for This Quiz
        List<UserAnswer> userAnswers = userAnswerRepository.findBySession(completedSession);

        if (userAnswers.isEmpty())
        {
            return ResponseEntity.status(404).body(new QuizResultDTO(0, 0, 0, "❌ No Answers Found for this Quiz!"));
        }

        // Count Correct & Wrong Answer
        int correctAnswers = 0;
        for (UserAnswer answer : userAnswers)
        {
            if (answer.getAnswer() == answer.getQuestion().getCorrectOption())
            {
                correctAnswers++;
            }
        }
        int totalQuestions = userAnswers.size();
        int wrongAnswers = totalQuestions - correctAnswers;

        // Final Response
        return ResponseEntity.ok(new QuizResultDTO(totalQuestions, correctAnswers, wrongAnswers, "✅ Quiz Completed!"));
    }
}