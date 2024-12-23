package com.book.book.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponsUtils<T> {
    private Integer code;//状态码 200 成功 304 失败
    private String message;// 信息 响应的信息结果
    private T data;// 数据 携带的数据

    public ResponsUtils(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}

