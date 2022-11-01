package com.laigaopeng.www.util;

/**
 * 用于判空的工具类
 */
public class EmptyCheckerUtil {

    public static boolean isStringEmpty(String target) {
        return (target == null || "".equals(target));
    }

    public static boolean isIntegerEmpty(Integer target) {
        return target == null;
    }

}
