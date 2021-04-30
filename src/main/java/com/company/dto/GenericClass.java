package com.company.dto;


import lombok.Data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class GenericClass<T> {
    //private String key;

    private Map<String, T> data;

   /* public GenericClass(T value,Class<?> cls){
        String key = "";
        if(value instanceof List){
            key = cls.getSimpleName().toLowerCase() + "List";
        }
        Map<String, T> dataList = new HashMap<String,T>();
        dataList.put(key,value);
        this.data = dataList;
    }*/

    public GenericClass(T value){

        String key = "";
        if(value instanceof List){
            key = value.getClass().getSimpleName().toLowerCase();
        }else{
            key = value.getClass().getSimpleName().toLowerCase();
        }

        Map<String, T> data = new HashMap<String,T>();
        data.put(key,value);
        this.data = data;

    }

}