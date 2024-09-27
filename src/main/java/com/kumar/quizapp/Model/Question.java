package com.kumar.quizapp.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;


@Data
@Entity
public class Question {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private  Integer id;
    public String questionsTitle;
    public String option1;
    public String option2;
    public String option3;
    public String option4;
    public String rightAnswer;
    public String difficultylevel;



}
