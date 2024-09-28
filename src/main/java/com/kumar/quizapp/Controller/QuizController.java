package com.kumar.quizapp.Controller;


import com.kumar.quizapp.Model.QuestionWrapper;
import com.kumar.quizapp.Service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("quiz")
public class QuizController {

    @Autowired
    QuizService quizService;

    @PostMapping("create")
    public ResponseEntity<String> CreateQuiz(@RequestParam String category,@RequestParam int numQ, @RequestParam String title ){
        return quizService.createQuiz(category,numQ,title);
    }


    //Get the quize
    @GetMapping("get/{id}")
    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(@PathVariable Integer id){
        return quizService.getQuizQuestions(id);
    }

}
