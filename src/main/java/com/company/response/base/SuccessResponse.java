package com.company.response.base;


import org.springframework.http.HttpStatus;

import java.io.Serializable;

public class SuccessResponse<T> extends ApiResponse implements Serializable {

    private T data;
    public SuccessResponse(T data){
        super(true);
        super.status = HttpStatus.OK.value();
        super.message = HttpStatus.OK.name();
        this.data = data;
    }
}
