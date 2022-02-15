package com.example.demo2.models;



import javax.persistence.*;
import java.util.List;

@Entity
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String question;
    private String answer;

    @OneToMany(mappedBy = "question")
    private List<PossibleAnswers> possibleAnswers;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public List<PossibleAnswers> getPossibleAnswers() {
        return possibleAnswers;
    }

    public void setPossibleAnswers(List<PossibleAnswers> possibleAnswers) {
        this.possibleAnswers = possibleAnswers;
    }
}
