package com.maarouf.qaApp.service;

//import com.maarouf.qaApp.assembler.QTypeModelAssembler;
import com.maarouf.qaApp.exceptions.QTypeNotFoundException;
import com.maarouf.qaApp.model.QuestionTypes;
import com.maarouf.qaApp.repository.QuestionTypesRepository;
import org.springframework.stereotype.Service;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@Service
public class QTypeService {

    private final QuestionTypesRepository questionTypesRepository;
    //private final QTypeModelAssembler qTypeModelAssembler;

    public QTypeService(QuestionTypesRepository questionTypesRepository /*QTypeModelAssembler qTypeModelAssembler*/) {
        this.questionTypesRepository = questionTypesRepository;
        //this.qTypeModelAssembler = qTypeModelAssembler;
    }

    /*
    public List<QuestionTypes> all(){
        return questionTypesRepository.findAll();
    }*/
    //get all elements in Qtype
    public Iterable<QuestionTypes> all(){
        return questionTypesRepository.findAll();
    }

    //get a single element
    public QuestionTypes one(Long id) /*throws QTypeNotFoundException */{
        QuestionTypes qtype = questionTypesRepository.findById(id)
                .orElseThrow(()-> new QTypeNotFoundException(id));
        return qtype;
    }

    public QuestionTypes oneByType(String typename){
        return questionTypesRepository.findIdByType(typename);
    }

    public QuestionTypes newQType(QuestionTypes newQuestionType){
        return questionTypesRepository.save(newQuestionType);
    }

    public QuestionTypes replaceQType(QuestionTypes newQType, Long id){
        QuestionTypes updatedQType = questionTypesRepository.findById(id)
                .map(qtype->{
                   qtype.setTypename(newQType.getTypename());
                   return questionTypesRepository.save(qtype);
                })
                .orElseGet(()->{
                    newQType.setTypeid(id);
                    return questionTypesRepository.save(newQType);
                });
        return updatedQType;
    }
    public void deleteType(Long id){
        QuestionTypes qtype =questionTypesRepository.findById(id)
                .orElseThrow(()-> new QTypeNotFoundException(id));
        questionTypesRepository.deleteById(id);
    }
}

