package com.API.payLoad;

import java.util.Date;

public class ErrorDetails {


    private Date date;
    private String message;
    private String request;

    public ErrorDetails(String message, Date date,String request) {
        this.message = message;
        this.date = date;

    }

    public void setMessage(String message) {

        this.message = message;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setRequest(String request) {

        this.request = request;
    }


}



