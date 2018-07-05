package com.zhang.sort;

import java.util.Arrays;

/**
 * 功能说明:    Shell 排序<br>
 * 系统版本: 2.0 <br>
 * 开发人员: zhangdl <br>
 * 开发时间:2018/5/23 09:11<br>
 * <br>
 */
public class TestShellSort {

    /**
     * @author jk，这个代码写的是shell排序，其实我个人认为这个排序的思想是把归并和快排的思想结合起来，快排是通过
     *         第一个元素来进行左右划分，归并是无论什么样，先将数组分成两组，然后继续分最后结合起来，这个shell排序，首先是将数组
     *         分为两组，然后进行插入，其实就类似将大的或者小的先放在前面或者后面，所以，我认为这个算法的复杂度应该和归并和快排是差不多的
     *
     */
    public static void main(String[] args) {
        int[] a = { 1, 4, 2, 0, 8, 6, 4, 6 };
        shellSort(a);
        // 输出排序后的数组
        System.out.println(Arrays.toString(a));

    }

    private static void shellSort(int[] a) {
        // 将数组分组
        for (int r = a.length / 2; r >= 1; r /= 2) {
            // 这里的思路和插入排序的思路相同，通过找到前一个的数大于或者小于来进行插入
            for (int i = r; i < a.length; i += r) {
                int temp = a[i];
                int j = i - r;
                while (j >= 0 && temp < a[j]) {
                    a[j + r] = a[j];
                    j -= r;
                }
                a[j + r] = temp;
            }
        }

    }

}
