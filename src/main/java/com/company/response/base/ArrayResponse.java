package com.company.response.base;

import org.springframework.http.HttpStatus;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;


public class ArrayResponse<T> extends ApiResponse implements Serializable {
    private Map<String, T> data;

    public Map<String, T> getData() {
        return data;
    }

    public void setData(Map<String, T> data) {
        this.data = data;
    }

    public ArrayResponse(String key , T value) {
        super(true);
        super.status = HttpStatus.OK.value();
        super.message = HttpStatus.OK.name();
        Map<String, T> data = new HashMap<String,T>();
        data.put(key,value);
        this.data = data;
    }
}
