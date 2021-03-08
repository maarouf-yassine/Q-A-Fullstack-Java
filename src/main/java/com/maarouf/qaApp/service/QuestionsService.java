package com.maarouf.qaApp.service;

import com.maarouf.qaApp.exceptions.QuestionNotFoundException;
import com.maarouf.qaApp.model.Questions;
import com.maarouf.qaApp.repository.QuestionsRepository;
import org.springframework.stereotype.Service;

@Service
public class QuestionsService {
    private final QuestionsRepository questionsRepository;

    public QuestionsService(QuestionsRepository questionsRepository) {
        this.questionsRepository = questionsRepository;
    }

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
