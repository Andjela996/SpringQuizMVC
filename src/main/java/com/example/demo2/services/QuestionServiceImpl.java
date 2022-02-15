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
    public void setAnswers(QuestionWrapper questionWrapper) {
        wrapper.setAns(questionWrapper.getAns());
    }


    @Override
    public void loadWrapper(Iterable<Question> questions){
        Iterator i = questions.iterator();
        wrapper = new QuestionWrapper();
        List<Question> map = new ArrayList<>();
        while(i.hasNext()){
            map.add((Question) i.next());
        }
        wrapper.setAnswers(map);
        Map<Long, String> map2 = new HashMap<>();
        while(i.hasNext()){
            map2.put(((Question)i.next()).getId(),"");
        }
        wrapper.setAns(map2);
    }

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
        int size = wrapper.getQuestions().size();
        int correct=0;
        for(Map.Entry<Long, String> q : wrapper.getAns().entrySet()){
            if(wrapper.getQuestions().get(Math.toIntExact(q.getKey())).getAnswer().equals(q.getValue())) correct++;
        }
        return correct*100/size;
    }
}
