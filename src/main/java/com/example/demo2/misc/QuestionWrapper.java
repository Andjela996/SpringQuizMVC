package com.example.demo2.misc;

import com.example.demo2.models.Question;
import org.springframework.stereotype.Component;


import java.util.Map;

//@Component
public class QuestionWrapper {

    private Map<Question, String> answers;

    private Map<Long, String> ans;

    public Map<Question, String> getAnswers() {
        return answers;
    }

    public void setAnswers(Map<Question, String> answers) {
        this.answers = answers;
    }

    public Map<Long, String> getAns() {
        return ans;
    }

    public void setAns(Map<Long, String> ans) {
        this.ans = ans;
    }
}
