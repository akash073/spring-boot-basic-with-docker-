package com.company.response.base;


import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.io.Serializable;

@Getter
public class SuccessResponse<T> extends ApiResponse implements Serializable {

    private T data;
    public SuccessResponse(T data,String message){
        super(true);
        super.status = HttpStatus.OK.value();
        super.message = message;
        this.data = data;
    }
}
