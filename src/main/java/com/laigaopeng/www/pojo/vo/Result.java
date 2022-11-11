package com.laigaopeng.www.pojo.vo;

/**
 * 返回前端的结果类对象
 *
 */
public class Result {

    private Object data; // 返回前端的数据
    private int code; // 状态码
    private String msg; // 信息

    public Result() {
    }

    public Result(Object data, int code) {
        this.data = data;
        this.code = code;
    }

    public Result(Object data, int code, String msg) {
        this.data = data;
        this.code = code;
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
