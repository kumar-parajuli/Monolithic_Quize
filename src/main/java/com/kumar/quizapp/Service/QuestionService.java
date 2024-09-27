package com.kumar.quizapp.Service;

import com.kumar.quizapp.Dao.QuestionsDao;
import com.kumar.quizapp.Model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {

    @Autowired
    QuestionsDao questionsDao;

    public List<Question> getAllQuestions() {
       return questionsDao.findAll();
    }


    public List<Question> getAllQuestionsByCategory(String category) {
        return questionsDao.findByCategory(category);
    }


    public String addQuestion(Question question) {
        questionsDao.save(question);
       return "Success";
    }
}
