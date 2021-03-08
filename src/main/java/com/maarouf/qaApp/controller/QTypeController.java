package com.maarouf.qaApp.controller;

import com.maarouf.qaApp.model.QuestionTypes;
import com.maarouf.qaApp.service.QTypeService;
import org.springframework.web.bind.annotation.*;

//import java.util.Optional;

//import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@RestController
public class QTypeController {

    private final QTypeService qTypeService;

    public QTypeController(QTypeService qTypeService) {
        this.qTypeService = qTypeService;
    }

    @GetMapping("/api/types")
    /*
    List<QuestionTypes> all() {
        return qTypeService.all();
    }*/
    public Iterable<QuestionTypes> all(){
        return qTypeService.all();
    }

    @GetMapping("api/types/{id}")
    public QuestionTypes one(@PathVariable Long id){
        return qTypeService.one(id);
    }

    @PostMapping("/api/types")
    QuestionTypes newQType(@RequestBody QuestionTypes newQType){
        return qTypeService.newQType(newQType);
    }

    @PutMapping("/api/types/{id}")
     QuestionTypes replaceQType(@RequestBody QuestionTypes newQType,@PathVariable Long id){
        return qTypeService.replaceQType(newQType,id);
    }

    @DeleteMapping("/api/types/{id}")
    void deleteQType(@PathVariable Long id){
        qTypeService.deleteType(id);
    }
}
