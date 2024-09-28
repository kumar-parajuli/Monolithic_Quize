package com.kumar.quizapp.Dao;

import com.kumar.quizapp.Model.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface QuizDao extends JpaRepository<Quiz,Integer> {
}
