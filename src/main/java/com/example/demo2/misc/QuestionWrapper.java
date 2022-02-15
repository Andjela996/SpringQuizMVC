package com.example.demo2.misc;

import com.example.demo2.models.Question;


import java.util.List;
import java.util.Map;

//@Component
public class QuestionWrapper {

    private List<Question> questions;

    private Map<Long, String> ans;

    public List<Question> getQuestions() {
        return questions;
    }

    public void setAnswers(List<Question> answers) {
        this.questions = answers;
    }

    public Map<Long, String> getAns() {
        return ans;
    }

    public void setAns(Map<Long, String> ans) {
        this.ans = ans;
    }
}
