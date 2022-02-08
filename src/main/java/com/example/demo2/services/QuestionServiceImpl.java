package com.example.demo2.services;

import com.example.demo2.misc.QuestionWrapper;
import com.example.demo2.models.Question;
import org.springframework.stereotype.Service;


import java.util.*;

@Service
public class QuestionServiceImpl implements QuestionService {

    private QuestionWrapper wrapper;


    @Override
    public QuestionWrapper getWrapper(){
        return wrapper;
    }

    @Override
    public void loadWrapper(Iterable<Question> questions){
        Iterator i = questions.iterator();
        wrapper = new QuestionWrapper();
        Map<Question, String> map = new HashMap<>();
        while(i.hasNext()){
            map.put((Question) i.next(), "");
        }
        wrapper.setAnswers(map);
        Map<Long, String> map2 = new HashMap<>();
        while(i.hasNext()){
            map2.put(((Question)i.next()).getId(),"");
        }
        wrapper.setAns(map2);
    }

    /*@Override
    public boolean checkAnswer(Question q, String ans) {
        boolean check = q.getAnswer().equals(ans) ? true : false;
        return check;
    }*/

    @Override
    public ArrayList<Question> chooseQuestions(ArrayList<Question> questions, int number) {
        Collections.shuffle(questions);
        if(number>questions.size()){
            return null;
        }
        return (ArrayList<Question>) questions.subList(0,number-1);

    }

    @Override
    public double calculateResult() {
        int size = wrapper.getAnswers().size();
        int correct=0;
        for(Map.Entry<Question, String> entry : wrapper.getAnswers().entrySet()){
            if(entry.getKey().getAnswer().equals(entry.getValue())) correct++;
        }
        return correct*100/size;
    }
}
