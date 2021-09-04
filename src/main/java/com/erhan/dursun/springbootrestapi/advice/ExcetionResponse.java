package com.erhan.dursun.springbootrestapi.advice;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
//@AllArgsConstructor
//@NoArgsConstructor
public class ExcetionResponse {

    private LocalDate timestamp;
    private String message;
    private String code;


    @Override
    public String toString() {
        return "ExcetionResponse{" +
                "timestamp=" + timestamp +
                ", message='" + message + '\'' +
                ", code='" + code + '\'' +
                '}';
    }

    public ExcetionResponse() {
    }

    public ExcetionResponse(LocalDate timestamp, String message, String code) {
        this.timestamp = timestamp;
        this.message = message;
        this.code = code;
    }

    public LocalDate getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDate timestamp) {
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
