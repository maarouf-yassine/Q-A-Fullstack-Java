package com.maarouf.qaApp.service;

import com.maarouf.qaApp.exceptions.QuestionNotFoundException;
import com.maarouf.qaApp.model.Questions;
import com.maarouf.qaApp.repository.QuestionTypesRepository;
import com.maarouf.qaApp.repository.QuestionsRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class QuestionsService {
    private final QuestionsRepository questionsRepository;
    private final QuestionTypesRepository questionTypesRepository;

    public QuestionsService(QuestionsRepository questionsRepository, QuestionTypesRepository questionTypesRepository) {
        this.questionsRepository = questionsRepository;
        this.questionTypesRepository = questionTypesRepository;
    }

    public Page<Questions> allPaginated(int pageNumber,int itemsPerPage){
        return questionsRepository.findAllQuestionsWithPagination(PageRequest.of(pageNumber, itemsPerPage));
    }

    public Page<Questions> filterByTypePaginated(String typename,int pageNumber,int elementsPerPage){
        Long typeid = questionTypesRepository.findIdByType(typename).getTypeid();
        return questionsRepository.findQuestionsByType(PageRequest.of(pageNumber,elementsPerPage),typeid);
    }

    public Page<Questions> searchForQuestions(String keyWord, int pageNumber, int elementsPerPage){
        return questionsRepository.searchForQuestions(PageRequest.of(pageNumber,elementsPerPage),keyWord);
    }

    //Non Paginated
    public Iterable<Questions> all(){
        return questionsRepository.findAll();
    }

    public Questions one(Long id){
        Questions question = questionsRepository.findById(id)
                .orElseThrow(()->new QuestionNotFoundException(id));
        return question;
    }

    public Questions newQuestion(Questions newQuestion){
        return questionsRepository.save(newQuestion);
    }

    public Questions replaceQuestion(Questions newquestion,Long id){
        Questions updatedQuestion = questionsRepository.findById(id)
                .map(question->{
                    question.setQtext(newquestion.getQtext());
                    question.setTypeid(newquestion.getTypeid());
                    return questionsRepository.save(question);
                })
                .orElseGet(()->{
                    newquestion.setTypeid(id);
                    return questionsRepository.save(newquestion);
                });
        return updatedQuestion;
    }

    public void deleteQuestion(Long id){
        Questions question = questionsRepository.findById(id)
                .orElseThrow(()->new QuestionNotFoundException(id));
    }
}
