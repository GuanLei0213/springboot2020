package com.gl.springboot.vo;

import lombok.Data;

@Data
public class ResultVO<T> {

    private boolean success;

    private String message;

    private long count;

    private T data;

    private ResultVO() {
    }

    public static ResultVO build(boolean success, String message){
        ResultVO vo = new ResultVO();
        vo.setSuccess(success);
        vo.setMessage(message);
        return vo;
    }

    public static ResultVO build(boolean success, String message, Object data){
        ResultVO vo = build(success,message);
        vo.setData(data);
        return vo;
    }

    public static ResultVO build(boolean success, String message, long count,Object data){
        ResultVO vo = build(success,message,data);
        vo.setCount(count);
        return vo;
    }
}
