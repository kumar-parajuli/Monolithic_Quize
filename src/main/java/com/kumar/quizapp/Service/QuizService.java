package com.kumar.quizapp.Service;


import com.kumar.quizapp.Dao.QuestionsDao;
import com.kumar.quizapp.Dao.QuizDao;
import com.kumar.quizapp.Model.Question;
import com.kumar.quizapp.Model.Quiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class QuizService {
    @Autowired
    QuizDao quizDao;
    @Autowired
    QuestionsDao questionsDao;

//create the quiz
    public ResponseEntity<String> createQuiz(String category, int numQ, String title) {
        List<Question> questions = questionsDao.findRandomQuestionsByCategory(category, numQ);
        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestions(questions);
        quizDao.save(quiz);
        return new ResponseEntity<>("success", HttpStatus.CREATED);
    }

    //Get the quize


}
