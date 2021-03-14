package com.maarouf.qaApp.controller;

import com.maarouf.qaApp.PacketsManager.AnswersOfQuestionPacket;
import com.maarouf.qaApp.PacketsManager.PageNumberPacket;
import com.maarouf.qaApp.PacketsManager.QuestionSearchPacket;
import com.maarouf.qaApp.model.Answers;
import com.maarouf.qaApp.service.AnswersService;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
public class AnswerController {

    private final AnswersService answersService;
    //enter number of elements you want to be displayed per page
    private final int itemsPerPage =5;

    public AnswerController(AnswersService answersService) {
        this.answersService = answersService;
    }

    @GetMapping("api/answers/page")
    Page<Answers> allPaginated(@RequestBody PageNumberPacket pageNumber){
        return answersService.allPaginated(pageNumber.getPagenumber()-1,itemsPerPage);
    }

    /*

    @GetMapping("api/answers/question")
    Page<Answers> answersOfQuestion(@RequestBody AnswersOfQuestionPacket packet){
        return answersService.AnswersOfQuestion(packet.getQid(), packet.getPagenumber()-1, itemsPerPage);
    }*/

    @GetMapping("api/answers/question/{qid}")
    Iterable<Answers> answersOfOneQuestion(@PathVariable Long qid){
        return answersService.AnswerOfQuestionByQuestionId(qid);
    }

    @GetMapping("/api/answers/{id}")
    Answers one(@PathVariable Long id){
        return answersService.one(id);
    }

    @GetMapping("/api/answers")
    Iterable<Answers> all(){
        return answersService.all();
    }

    @PostMapping("api/answers")
    Answers newAnswer(@RequestBody Answers newAnswer){
        return answersService.newAnswer(newAnswer);
    }

    @PutMapping("api/answers/{id}")
    public Answers replaceAnswer(@RequestBody Answers newAnswer,@PathVariable Long id){
        return answersService.replaceAnswer(newAnswer,id);
    }

    @DeleteMapping("api/answers/{id}")
    public void deleteAnswer(@PathVariable Long id){
        answersService.deleteAnswer(id);
    }
}
