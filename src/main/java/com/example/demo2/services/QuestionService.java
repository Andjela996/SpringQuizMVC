package com.example.demo2.services;

import com.example.demo2.misc.QuestionWrapper;
import com.example.demo2.models.Question;

import java.util.ArrayList;

public interface QuestionService {
   // boolean checkAnswer(Question q, String ans);
    void loadWrapper(Iterable<Question> questions);
    ArrayList<Question> chooseQuestions(ArrayList<Question> questions, int number);
    double calculateResult();
    QuestionWrapper getWrapper();
}
