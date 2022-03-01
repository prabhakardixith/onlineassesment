package com.jmz.onlineassessmentexamportal.helper;

import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDate;
import java.util.Date;

@Data
public class ExceptionClass
{
    private HttpStatus status;
    private String error;
    private String message;
    private String time;
}
