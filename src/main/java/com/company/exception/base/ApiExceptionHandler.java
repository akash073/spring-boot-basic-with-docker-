package com.company.exception.base;


import com.company.exception.ValidationException;
import com.company.response.base.ErrorResponse;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Created by DELL on 22-Jul-19.
 */
//@RestControllerAdvice(basePackages ={"com.cnsbd.bsp.api.login","com.cnsbd.bsp.api.v1"})
@RestControllerAdvice(basePackages ={"com.company.controller"})
public class ApiExceptionHandler {

    @ResponseBody
    @ExceptionHandler(value = ValidationException.class)
    public ResponseEntity<?> handleException(ValidationException exception) {

        HttpStatus httpStatus = HttpStatus.OK;
        String message = exception.getMessage();

        ErrorResponse errorResponse = new ErrorResponse(HttpStatus.BAD_REQUEST,message);
        Gson gson = new GsonBuilder().serializeNulls().create();
        String jsonResponse = gson.toJson(errorResponse);
        return ResponseEntity.status(httpStatus).contentType(MediaType.parseMediaType("application/json;charset=UTF-8")).body(jsonResponse);
    }

    /*@ResponseBody
    @ExceptionHandler(value = TokenExpiredException.class)
    public ResponseEntity<?> handleException(TokenExpiredException exception) {

        HttpStatus httpStatus = HttpStatus.OK;
        String message = exception.getMessage();

        com.cnsbd.bsp.api.v1.response.base.ErrorResponse errorResponse = new com.cnsbd.bsp.api.v1.response.base.ErrorResponse(HttpStatus.BAD_REQUEST,message);
        Gson gson = new GsonBuilder().serializeNulls().create();
        String jsonResponse = gson.toJson(errorResponse);
        return ResponseEntity.status(httpStatus).contentType(MediaType.parseMediaType("application/json;charset=UTF-8")).body(jsonResponse);
    }*/
}
