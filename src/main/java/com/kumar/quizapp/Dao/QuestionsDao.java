package com.kumar.quizapp.Dao;


import com.kumar.quizapp.Model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionsDao  extends JpaRepository<Question,Integer> {

List<Question>findByCategory(String category);
}
