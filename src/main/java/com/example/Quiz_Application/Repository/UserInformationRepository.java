package com.example.Quiz_Application.Repository;

import com.example.Quiz_Application.Model.UserInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserInformationRepository extends JpaRepository<UserInformation, Long>
{
    boolean existsByUserEmail(String userEmail);
}
