package com.book.book.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseUtils<T> {
    private Integer code;  //状态码 200 成功 304 失败
    private String message;  //信息 响应的信息结果
    private T data;  //携带的数据

    public ResponseUtils(Integer code, String message) {
        this.code = code;
        this.message = message;
    }


    public ResponseUtils(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    // Getters and setters
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}

