package com.laigaopeng.www.util.enumhelper;

/**
 * 返回前端的结果状态码及状态信息
 *
 */
public enum CodeEnum {

    SUCCESS(30001, "成功"),
    FAIL(30002, "失败"),
    NO_PERMISSION(30003, "没有权限"),
    WRONG_PARAMETER(30004, "参数不合法"),
    EXCEPTION(30005, "出现异常");


    private final Integer code;
    private final String msg;

    CodeEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
