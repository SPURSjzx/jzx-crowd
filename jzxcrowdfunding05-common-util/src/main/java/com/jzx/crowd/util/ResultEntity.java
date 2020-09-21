package com.jzx.crowd.util;

import com.sun.org.apache.regexp.internal.RE;

/**
 * 统一整个项目中Ajax请求返回的结果（分布式中也可以使用的）
 * @title: ResultEntity
 * @Author Jzxxxx
 * @Date: 2020/9/17 20:24
 * @Version 1.0
 */
public class ResultEntity<T> {

    public static  final  String SUCCESS="SUCCESS";
    public static  final  String FAILED="FAILED";
    /**
     * 用来封装当前请求处理的结果是成功还是失败
     */
    private String result;
    /**
     * 请求失败时返回的错误消息
     */
    private String message;
    //要返回的数据
    private T data;

    /**
     * 当请求成功而且不需要返回数据时
     * @param <E>
     * @return
     */
    public static  <E> ResultEntity<E> successWithoutData(){
        return new ResultEntity<E>(SUCCESS,null,null);
    }

    /**
     * 当请求成功而且需要返回数据时
     * @param <E>
     * @return
     */
    public static  <E> ResultEntity<E> successWithData(E data){
        return new ResultEntity<E>(SUCCESS,null,data);
    }
    /**
     * 当请求失败时
     * @param message 失败的错误消息
     * @return
     */
    public static  <E> ResultEntity<E> failed(String message){
        return new ResultEntity<E>(FAILED,message,null);
    }
    public ResultEntity() {
    }

    public ResultEntity(String result, String message, T data) {
        this.result = result;
        this.message = message;
        this.data = data;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
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
