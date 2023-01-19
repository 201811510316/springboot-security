package com.example.springbootsecurity.utils;

import lombok.Data;

@Data
public class responseBody<T> {

    private Integer code;
    private String message;
    private T object;

    public responseBody(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public responseBody(Integer code, String message, T object) {
        this.code = code;
        this.message = message;
        this.object = object;
    }

    public responseBody() {
    }

    public static <T> responseBody<T> success(String message,T object){
        return new responseBody<T>(200,message,object);
    }
    public static <T> responseBody<T> success(T object){
        return new responseBody<T>(200,"操作成功",object);
    }
    public static <T> responseBody<T> fail(String message){
        return new responseBody<T>(404,message);
    }
    public static <T> responseBody<T> fail(){
        return new responseBody<T>(404,"操作失败");
    }

}
