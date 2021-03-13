package com.maarouf.qaApp.controller;

import com.maarouf.qaApp.PacketsManager.PageNumberPacket;
import com.maarouf.qaApp.PacketsManager.QuestionSearchPacket;
import com.maarouf.qaApp.PacketsManager.QuestionsByTypePacket;
import com.maarouf.qaApp.model.Questions;
import com.maarouf.qaApp.service.QuestionsService;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
public class QuestionController {
    private final QuestionsService questionsService;

    //SET THE NUMBER OF ELEMENTS YOU WANT TO DISPLAY PER PAGE
    private final int elementsPerPage = 5;

    public QuestionController(QuestionsService questionsService) {
        this.questionsService = questionsService;
    }


    @GetMapping("/api/questions/page/{pagenumber}")
    Page<Questions> allPaginated(@PathVariable int  pagenumber){
        return questionsService.allPaginated(pagenumber-1,elementsPerPage);
    }
    /*
    @GetMapping("/api/questions/page")
    Page<Questions> allPaginated(@RequestBody PageNumberPacket pagenumber){
        return questionsService.allPaginated(pagenumber.getPagenumber()-1,elementsPerPage);
    }*/

    /*
    @GetMapping("/api/questions/byType/{type}/{pagenumber}")
    Page<Questions> filterByTypePaginated(@PathVariable String type,@PathVariable int pagenumber ){
        return questionsService.filterByTypePaginated(type,pagenumber-1,elementsPerPage);
    }*/

    @GetMapping("/api/questions/byType")
    Page<Questions> filterByTypePaginated(@RequestBody QuestionsByTypePacket newquestionfilter){
        return questionsService.filterByTypePaginated(newquestionfilter.getTypename(),newquestionfilter.getPagenumber()-1,elementsPerPage);
    }

    @GetMapping("api/questions/search")
    Page<Questions> searchForQuestions(@RequestBody QuestionSearchPacket newsearch){
        return questionsService.searchForQuestions(newsearch.getKeyword(),newsearch.getPagenumber()-1,elementsPerPage);
    }


    @GetMapping("/api/questions/{id}")
    Questions one(@PathVariable Long id){
        return questionsService.one(id);
    }

    @GetMapping("/api/questions")
    Iterable<Questions> all(){
        return questionsService.all();
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
