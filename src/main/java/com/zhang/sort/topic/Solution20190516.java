package com.zhang.sort.topic;

import java.util.HashSet;
import java.util.Set;

/**
 *
 */
public class Solution20190516 {

    public static String replaceSpace(StringBuffer str) {
        return str.toString().replaceAll(" ","%20");
    }

    public static void main(String[] args) {
        StringBuffer str = new StringBuffer("we are happy");
//        System.out.println(replaceSpace(str));
        int a = lengthOfLongestSubstring(str.toString());
        System.out.println(a);
    }

    public static int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int ans = 0;
        for (int i = 0; i < n; i++)
            for (int j = i + 1; j <= n; j++)
                if (allUnique(s, i, j)) ans = Math.max(ans, j - i);
        return ans;
    }

    public static boolean allUnique(String s, int start, int end) {
        Set<Character> set = new HashSet<>();
        for (int i = start; i < end; i++) {
            Character ch = s.charAt(i);
            if (set.contains(ch)) return false;
            set.add(ch);
        }
        return true;
    }

}
