package com.maarouf.qaApp.exceptions;

public class AnswerNotFoundException extends RuntimeException{
    public AnswerNotFoundException(Long id){
        super("Could not find answer: "+id);
    }
}
