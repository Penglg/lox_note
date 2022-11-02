package com.laigaopeng.www.util;

/**
 * 审批申请的结果枚举类
 *
 */
public enum ApprovalEnum {

    UNPROCESSED(-1, "未处理"),
    NOT_PASSED(0, "不通过"),
    PASSED(1, "通过");


    private final Integer result;
    private final String desc;

    ApprovalEnum(Integer result, String desc) {
        this.result = result;
        this.desc = desc;
    }

    public Integer getResult() {
        return result;
    }

    public String getDesc() {
        return desc;
    }
}
