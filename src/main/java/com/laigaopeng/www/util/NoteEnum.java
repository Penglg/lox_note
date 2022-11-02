package com.laigaopeng.www.util;

public enum NoteEnum {

    ILLEGAL(0),
    LEGAL(1);

    private final Integer code;

    NoteEnum(Integer code) {
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }
}
