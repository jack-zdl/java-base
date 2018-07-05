package com.zhang.sort;

import java.util.Arrays;

/**
 * 功能说明: 插入排序   <br>
 * 系统版本: 2.0 <br>
 * 开发人员: zhangdl <br>
 * 开发时间:2018/7/5 16:09<br>
 * <br>
 */
public class TestInsertSort {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,1};
        int tmp;
                for(int i = 1; i < arr.length; i++) {
                    // 待插入数据
                        tmp = arr[i];
                         int j;
                         for(j = i - 1; j >= 0; j--) {
                             // 判断是否大于tmp，大于则后移一位
                            if(arr[j] > tmp) {
                                 arr[j+1] = arr[j];
                             }else{
                                 break;
                           }
                       }
                      arr[j+1] = tmp;
                       System.out.println(i + ":" + Arrays.toString(arr));
                    }
    }
}
