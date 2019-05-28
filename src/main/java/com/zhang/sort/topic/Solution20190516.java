package com.zhang.sort.topic;

/**
 *
 */
public class Solution20190516 {

    public static String replaceSpace(StringBuffer str) {
        return str.toString().replaceAll(" ","%20");
    }

    public static void main(String[] args) {
        StringBuffer str = new StringBuffer("we are happy");
        System.out.println(replaceSpace(str));
    }
}
