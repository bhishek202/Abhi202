package com.API.Config;

import com.API.payLoad.ErrorDetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;
import java.util.regex.PatternSyntaxException;

@ControllerAdvice
public class HandleException {
    //ResoureNotFound exception occure your project that code handle the exception
    @ExceptionHandler(ResourceNotFound.class)
    public ResponseEntity<ErrorDetails> handleEmployeeNotFoundException(ResourceNotFound e,WebRequest request)
    {

        ErrorDetails errorDetails=new ErrorDetails(e.getMessage(),new Date(),request.getDescription(true));
        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    //occur exception in your project that code handle the erro
   @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDetails> handleEmployeeException(Exception e,WebRequest request)
    {

        ErrorDetails errorDetails=new ErrorDetails(e.getMessage(),new Date(),request.getDescription(true));
       return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
