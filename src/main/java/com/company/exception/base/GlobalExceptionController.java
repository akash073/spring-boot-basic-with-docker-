package com.company.exception.base;


import com.company.response.base.ErrorResponse;
import com.google.gson.Gson;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalExceptionController {

    @ExceptionHandler(Exception.class)
    public Object handleError405(HttpServletRequest request, Exception e)   {

        HttpStatus httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        String message = e.getMessage();

        ErrorResponse errorResponse = new ErrorResponse(httpStatus,message);
        String jsonResponse = new Gson().toJson(errorResponse);
        return ResponseEntity.status(httpStatus).contentType(MediaType.APPLICATION_JSON).body(jsonResponse);

    }
}
