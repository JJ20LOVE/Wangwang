package com.itcaptain.ecnutrade.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class Result<T> {
    private int status;//业务状态码 1成功0失败
    private String message;
    private T data;//响应数据

    //返回操作成功响应结果(带相应数据)
    public static <E> Result<E> success(E data) {
        return new Result<>(1, "操作成功",null);
    }

    //返回操作成功响应结果
    public static Result success(){return new Result(1,"操作成功", null);}

    public static Result error(Integer status,String message) {return new Result(0, message, null);}

}


