package br.com.vertigo.exercicio.tsantos.api.controller.handler;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ErrorModel implements Serializable {

    private static final long serialVersionUID = 1L;
    @JsonFormat(pattern = "dd/mm/yyyy")
    private LocalDateTime timeStamp;
    private String status;
    private String from;
    private String message;


    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(LocalDateTime timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
