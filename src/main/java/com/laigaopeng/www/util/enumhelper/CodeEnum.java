package com.laigaopeng.www.util.enumhelper;

public enum CodeEnum {

    SAVE_SUCCESS(30001),
    UPDATE_SUCCESS(30002),
    DELETE_SUCCESS(30003),
    GET_SUCCESS(30004),

    SAVE_FAIL(40001),
    UPDATE_FAIL(40002),
    DELETE_FAIL(40003),
    GET_FAIL(40004);

    private final Integer code;

    CodeEnum(Integer code) {
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }
}
