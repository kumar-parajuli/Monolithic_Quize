package com.kumar.quizapp.Service;


import com.kumar.quizapp.Dao.QuestionsDao;
import com.kumar.quizapp.Dao.QuizDao;
import com.kumar.quizapp.Model.Question;
import com.kumar.quizapp.Model.QuestionWrapper;
import com.kumar.quizapp.Model.Quiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


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


    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(Integer id) {
        Optional<Quiz> quiz = quizDao.findById(id);
        if (quiz.isPresent()) {
            List<Question> questionsFromDB = quiz.get().getQuestions();
            List<QuestionWrapper> questionsForUser = new ArrayList<>();
            for (Question q : questionsFromDB) {
                QuestionWrapper qw = new QuestionWrapper(q.getId(), q.getQuestionsTitle(), q.getOption1(), q.getOption2(), q.getOption3(), q.getOption4());
                questionsForUser.add(qw);
            }
            return new ResponseEntity<>(questionsForUser, HttpStatus.OK);

        } else {
            // Return a response indicating the quiz was not found
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
