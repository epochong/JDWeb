package com.epochong.util;

/**
 * @author epochong
 * @date 2019/10/21 15:23
 * @email epochong@163.com
 * @blog epochong.github.io
 * @describe
 */
public class CommonUtil {
    public static boolean isNull(String ... strings) {
        for (int i = 0; i < strings.length; i++) {
            if ("".equals(strings[i]) || null == strings[i]) {
                return true;
            }
        }
        return false;
    }
}
