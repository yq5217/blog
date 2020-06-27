package com.yang.blog.until;

import java.io.Serializable;

public class ResJson<T> implements Serializable {

    private int status;
    
    private String message;

    private T result;

	public int getStatus() {
		return status;
	}

	public String getMessage() {
		return message;
	}

	public T getResult() {
		return result;
	}
    
    private ResJson(int status) {
    	this.status = status;
    }
    
    private ResJson(int status, String message) {
    	this.status = status;
    	this.message = message;
    }
    
    private ResJson(int status, T result) {
    	this.status = status;
    	this.result = result;
    }
    
    private ResJson(int status, String message, T result) {
    	this.status = status;
    	this.message = message;
    	this.result = result;
    }

    //使之不在json序列化结果当中
    public boolean isSuccess(){
        return this.status == ResponseCode.SUCCESS.getCode();
    }
    
    public static <T> ResJson<T> createBySuccess(){
        return new ResJson<T>(ResponseCode.SUCCESS.getCode());
    }

    public static <T> ResJson<T> createBySuccessMessage(String message){
        return new ResJson<T>(ResponseCode.SUCCESS.getCode(),message);
    }

    public static <T> ResJson<T> createBySuccess(T result){
        return new ResJson<T>(ResponseCode.SUCCESS.getCode(),result);
    }

    public static <T> ResJson<T> createBySuccess(String message,T result){
        return new ResJson<T>(ResponseCode.SUCCESS.getCode(),message,result);
    }


    public static <T> ResJson<T> createByError(){
        return new ResJson<T>(ResponseCode.ERROR.getCode(),ResponseCode.ERROR.getDesc());
    }
    public static <T> ResJson<T> createByError(String message){
        return new ResJson<T>(ResponseCode.ERROR.getCode(), message);
    }
}
