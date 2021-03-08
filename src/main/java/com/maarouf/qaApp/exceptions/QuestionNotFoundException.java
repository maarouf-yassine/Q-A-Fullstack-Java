package com.maarouf.qaApp.exceptions;

public class QuestionNotFoundException extends RuntimeException{
    public QuestionNotFoundException(Long id){
        super("Could not find question type: "+id);
    }
}
