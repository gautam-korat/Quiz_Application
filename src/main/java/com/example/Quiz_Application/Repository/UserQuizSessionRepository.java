package com.example.Quiz_Application.Repository;

import com.example.Quiz_Application.Model.UserQuizSession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserQuizSessionRepository extends JpaRepository<UserQuizSession, Long>
{
    @Query(value = "SELECT * FROM user_quiz_session WHERE user_id = :userId AND status = 'ACTIVE' ORDER BY start_time DESC LIMIT 1", nativeQuery = true)
    Optional<UserQuizSession> findLatestActiveSession(@Param("userId") Long userId);

    @Query(value = "SELECT * FROM user_quiz_session WHERE user_id = :userId AND status = 'COMPLETE' ORDER BY start_time DESC LIMIT 1", nativeQuery = true)
    Optional<UserQuizSession> findLatestCompletedSession(@Param("userId") Long userId);
}
