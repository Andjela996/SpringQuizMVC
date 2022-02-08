package com.example.demo2.models;

import jdk.nashorn.internal.runtime.logging.Logger;

import javax.persistence.*;

@Entity
public class PossibleAnswers {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long ansID;

    @ManyToOne
    @JoinColumn(name = "id", nullable = false)
    private Question question;
    private String answer;

    public Question getQuestion() {
        return question;
    }

    public long getId() {
        return ansID;
    }

    public void setId(long id) {
        this.ansID= id;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
