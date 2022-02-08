package com.example.demo2.controllers;

import com.example.demo2.login.LoginCredentials;
import com.example.demo2.misc.QuestionWrapper;
import com.example.demo2.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class QuizController {
    @Autowired
    private ResultRepository resultRepository;

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private UserRepository userRepository;

    private UserService userService;
    private QuestionService questionService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setQuestionService(QuestionService questionService) {
        this.questionService = questionService;
    }


    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@ModelAttribute("loginCreds") LoginCredentials loginCredentials, Model model){
        if(!userService.checkLogin(loginCredentials, userRepository.findAll())){
            System.out.println("user not found:"+loginCredentials.getUsername());
            return "loginform";
        }
        else{
            questionService.loadWrapper(questionRepository.findAll());
            model.addAttribute("questions", questionService.getWrapper());
            model.addAttribute("user",loginCredentials.getUsername());

        }
        return "quiz";
    }

    @RequestMapping("/loginform")
    public String loginform(){
        return "loginform";
    }


    @ModelAttribute(value = "loginCreds")
    public LoginCredentials newEntity()
    {
        return new LoginCredentials();
    }


    @RequestMapping("/results")
    public String getAllResults(Model model){
        model.addAttribute("results", resultRepository.findAll());
        return "toplist";
    }


    @RequestMapping(value = "/getresult", method = RequestMethod.POST)
    public @ResponseBody String
    result(@ModelAttribute(name="questions") QuestionWrapper questions){
        System.out.println(questions.getAns());
        return "result saved";
    }
}
