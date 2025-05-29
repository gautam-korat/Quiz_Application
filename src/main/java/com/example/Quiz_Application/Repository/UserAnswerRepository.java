package com.example.Quiz_Application.Repository;

import com.example.Quiz_Application.Model.Question;
import com.example.Quiz_Application.Model.UserAnswer;
import com.example.Quiz_Application.Model.UserInformation;
import com.example.Quiz_Application.Model.UserQuizSession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserAnswerRepository extends JpaRepository<UserAnswer, Long> {


    int countBySession(UserQuizSession session);

    @Query("SELECT COUNT(u) > 0 FROM UserAnswer u WHERE u.user = :user AND u.session = :session AND u.question = :question")
    boolean answerAlreadySubmitted(@Param("user") UserInformation user, @Param("session") UserQuizSession session, @Param("question") Question question);

    @Query("SELECT ua FROM UserAnswer ua WHERE ua.session = :session")
    List<UserAnswer> findBySession(@Param("session") UserQuizSession session);
}
