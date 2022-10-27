package cn.edcheung.javaWebBase.utils;

/**
 * StringUtils TODO
 *
 * @author Edward Cheung
 * 2019/11/3
 */
public class StringUtils {
    public static boolean isEmpty(String str) {
        return str == null || str.length() == 0;
    }

    public static boolean isNotEmpty(String str) {
        return !isEmpty(str);
    }
}
