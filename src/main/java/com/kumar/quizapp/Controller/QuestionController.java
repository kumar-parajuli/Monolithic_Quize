package com.kumar.quizapp.Controller;


import com.kumar.quizapp.Model.Question;
import com.kumar.quizapp.Service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("questions")
public class QuestionController {
@Autowired
    QuestionService questionService;

    @GetMapping("allQuestions")
    public List<Question> getAllQuestions(){
        return questionService.getAllQuestions();
    }


    //method to get data according to catogory
    @GetMapping("category/{category}")
public List<Question>getAllQuestionByCategory(@PathVariable String category){
        return  questionService.getAllQuestionsByCategory(category);
}

//Adding the data on question
    @PostMapping("add")
    public  String addQuestion(@RequestBody Question question){
        return questionService.addQuestion(question);
    }



}
