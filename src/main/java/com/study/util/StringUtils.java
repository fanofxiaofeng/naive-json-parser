package com.study.util;

public class StringUtils {
    public static String fromCodePoint(int codePoint) {
        return new String(new int[]{codePoint}, 0, 1);
    }

    public static String fromStringArray(String... strings) {
        StringBuilder builder = new StringBuilder();
        for (String s : strings) {
            builder.append(s);
        }
        return builder.toString();
    }
}
