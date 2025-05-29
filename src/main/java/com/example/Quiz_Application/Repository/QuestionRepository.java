package com.example.Quiz_Application.Repository;

import com.example.Quiz_Application.Model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long>
{
    // fetch random 5 question
    @Query(value = "select * from question order by rand() limit 5", nativeQuery = true)
    List<Question> findRandomQuestion();

    // Check if Question is Already Exists or Not
    boolean existsByQuestion(String question);

}
