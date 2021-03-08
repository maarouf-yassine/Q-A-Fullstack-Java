package com.maarouf.qaApp.controller;

import com.maarouf.qaApp.model.Questions;
import com.maarouf.qaApp.service.QuestionsService;
import org.springframework.web.bind.annotation.*;

@RestController
public class QuestionController {
    private final QuestionsService questionsService;

    public QuestionController(QuestionsService questionsService) {
        this.questionsService = questionsService;
    }

    @GetMapping("/api/questions")
    Iterable<Questions> all(){
        return questionsService.all();
    }

    @GetMapping("/api/questions/{id}")
    Questions one(@PathVariable Long id){
        return questionsService.one(id);
    }

    @PostMapping("api/questions")
    Questions newQuestion(@RequestBody Questions newQuestion){
        return questionsService.newQuestion(newQuestion);
    }

    @PutMapping("api/questions/{id}")
    public Questions replaceQuestion(@RequestBody Questions newQuestion,@PathVariable Long id){
        return questionsService.replaceQuestion(newQuestion,id);
    }

    @DeleteMapping("api/questions/{id}")
    public void deleteQuestion(@PathVariable Long id){
        questionsService.deleteQuestion(id);
    }
}
