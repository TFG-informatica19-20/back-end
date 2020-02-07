package com.microservices.tournamentx.battleshipqueue.domain;

import com.microservices.tournamentx.battleshipqueue.exceptions.IncorrectStateException;
import lombok.SneakyThrows;

public enum Status {
    INITIALIZING, READY, STARTING, STARTED, CANCELED;

    @SneakyThrows(IncorrectStateException.class)
    public static Status nextStatus(Status status) {
        switch(status){
            case INITIALIZING: return Status.READY;
            case READY: return Status.STARTING;
            case STARTING: return Status.STARTED;
            default: throw new IncorrectStateException("The status cannot be updated");
        }
    }
}
