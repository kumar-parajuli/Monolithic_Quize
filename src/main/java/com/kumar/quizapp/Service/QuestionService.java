package com.kumar.quizapp.Service;

import com.kumar.quizapp.Dao.QuestionsDao;
import com.kumar.quizapp.Model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {

    @Autowired
    QuestionsDao questionsDao;

    public ResponseEntity< List<Question>> getAllQuestions() {
        try {
            return new ResponseEntity<>(questionsDao.findAll(), HttpStatus.OK);

        } catch (Exception e){

            e.printStackTrace();
        }
            return new ResponseEntity<>(questionsDao.findAll(), HttpStatus.BAD_REQUEST);

    }


    public ResponseEntity<List<Question>> getAllQuestionsByCategory(String category) {
        try {
            return new ResponseEntity<>(questionsDao.findByCategory(category), HttpStatus.OK);
        } catch (Exception e) {

            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList(), HttpStatus.BAD_REQUEST);

    }

        public ResponseEntity<String >addQuestion(Question question) {
        try {
           new ResponseEntity<>( questionsDao.save(question),HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>("success",HttpStatus.BAD_REQUEST);
    }
}
