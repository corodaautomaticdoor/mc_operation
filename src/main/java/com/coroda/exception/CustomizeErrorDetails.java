package com.coroda.exception;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.Date;

@Getter
public class CustomizeErrorDetails {

    @JsonProperty("timeStamp")
    private Date timeStamp;
    @JsonProperty("message")
    private String message;
    @JsonProperty("details")
    private String details;

    public CustomizeErrorDetails(Date timeStamp, String message, String details) {
        this.timeStamp = timeStamp;
        this.message = message;
        this.details = details;
    }
}
