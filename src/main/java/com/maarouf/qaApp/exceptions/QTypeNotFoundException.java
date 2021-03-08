package com.maarouf.qaApp.exceptions;

public class QTypeNotFoundException extends RuntimeException {
    public QTypeNotFoundException(Long id) {
        super("Could not find question type: "+id);
    }
}
