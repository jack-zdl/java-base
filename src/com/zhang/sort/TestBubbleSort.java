package com.zhang.sort;

/**
 * 功能说明: 冒泡算法 <br>
 * 系统版本: 2.0 <br>
 * 开发人员: zhangdl <br>
 * 开发时间: 2018/2/1 21:50<br>
 */

public class TestBubbleSort {

    public static void main(String[] args) {
        int[] numbers ={1,2,3,4,5,1,2,3,4};
        int temp = 0;
        int size = numbers.length;
        for(int i = 0 ; i < size-1; i ++)
        {
            for(int j = 0 ;j < size-1-i ; j++)
            {
                if(numbers[j] > numbers[j+1])  //交换两数位置
                {
                    temp = numbers[j];
                    numbers[j] = numbers[j+1];
                    numbers[j+1] = temp;
                }
            }
        }

    }
}
