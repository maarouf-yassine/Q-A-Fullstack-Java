package com.maarouf.qaApp.service;

import com.maarouf.qaApp.exceptions.AnswerNotFoundException;
import com.maarouf.qaApp.model.Answers;
import com.maarouf.qaApp.model.Questions;
import com.maarouf.qaApp.repository.AnswersRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class AnswersService {
    private final AnswersRepository answersRepository;


    public AnswersService(AnswersRepository answersRepository) {
        this.answersRepository = answersRepository;
    }

    public Page<Answers> allPaginated(int pageNumber,int itemsPerPage){
        return answersRepository.findAllAnswersWithPagination(PageRequest.of(pageNumber,itemsPerPage));
    }

    /*
    public Page<Answers> AnswersOfQuestion(Long qid,int pageNumber,int itemsPerPage){
        return answersRepository.getAnswersOfQuestion(PageRequest.of(pageNumber,itemsPerPage), qid);
    }*/

    public Iterable<Answers> AnswerOfQuestionByQuestionId(Long questionId){
        return answersRepository.getAnswersOfQuestion(questionId);
    }

    public Iterable<Answers> all(){
        return answersRepository.findAll();
    }

    public Answers one(Long id){
        Answers answer = answersRepository.findById(id)
                .orElseThrow(()->new AnswerNotFoundException(id));
        return answer;
    }

    public Answers newAnswer(Answers newAnswer){

        return answersRepository.save(newAnswer);
    }

    public Answers replaceAnswer(Answers newAnswer,Long id){
        Answers updatedAnswer= answersRepository.findById(id)
                .map(answer->{
                    answer.setAnswer(newAnswer.getAnswer());
                    answer.setQid(newAnswer.getQid());
                    return answersRepository.save(answer);
                })
                .orElseGet(()->{
                    newAnswer.setAnswerid(id);
                    return answersRepository.save(newAnswer);
                });
        return updatedAnswer;
    }

    public void deleteAnswer(Long id){
        Answers answer = answersRepository.findById(id)
                .orElseThrow(()->new AnswerNotFoundException(id));
        answersRepository.delete(answer);
    }
}
