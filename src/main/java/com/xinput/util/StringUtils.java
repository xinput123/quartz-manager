package com.xinput.util;

/**
 * @author xinput
 */
public class StringUtils {

    /**
     * 空字符串
     */
    public final static String EMPTY = "";

    /**
     * 逗号
     */
    public final static String COMMA = ",";

    /**
     * 点，点号
     */
    public final static String POINT = ".";

    /**
     * 为空
     *
     * @param str
     * @return
     */
    public static boolean isNullOrEmpty(String str) {
        if (str == null || EMPTY.equals(str.trim())) {
            return true;
        }

        return false;
    }

    /**
     * 不为空
     *
     * @param str
     * @return
     */
    public static boolean isNotNullOrEmpty(String str) {
        return !isNullOrEmpty(str);
    }

    /**
     * 为空
     *
     * @param strs
     * @return
     */
    public static boolean isNullOrEmpty(String... strs) {
        if (null == strs || strs.length == 0) {
            return true;
        }

        for (String str : strs) {
            if (isNullOrEmpty(str)) {
                return true;
            }
        }

        return false;
    }
}
