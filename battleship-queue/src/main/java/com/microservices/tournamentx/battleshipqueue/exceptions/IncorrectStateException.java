package com.microservices.tournamentx.battleshipqueue.exceptions;

public class IncorrectStateException extends Exception {
    public IncorrectStateException(String errorMessage) {super(errorMessage);}
}
