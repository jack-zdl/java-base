package com.zhang.util;

import java.util.Locale;

/**
 * @Description:
 * @Author: dl.zhang
 * @CreateDate: 2019/3/5 12:40
 **/
public class StringUtil {

    public static void main(String[] args) {
        System.out.println("TITLE".toLowerCase());
//        System.out.println("TITLE".toLowerCase(Locale.ROOT));
//        System.out.println("TITLE".toLowerCase(Locale.FRANCE));
        String s = String.format ("\\u%04x", (int)Character.MIN_HIGH_SURROGATE);
        System.out.println(s);  //\ud800

        char c = 'A';
        System.out.println();

    }
}
