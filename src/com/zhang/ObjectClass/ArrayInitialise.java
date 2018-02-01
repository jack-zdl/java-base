package com.zhang.ObjectClass;

/**
 * 功能说明: 数组的初始化<br>
 * 系统版本: 2.0 <br>
 * 开发人员: zhangdl <br>
 * 开发时间: 2018/2/1 21:57<br>
 */

public class ArrayInitialise {

    /**
     * int 数组初始化
     */
    public static void intArray(){
        int[] a = {1,3,4,5,6};
//        for (int b = 0 ; b<a.length;b++){
//            System.out.println("b="+a[b]);
//        }
        int[] a1 = new int[7];
        for (int c = 0 ; c<a1.length;c++){
            System.out.println("c="+c+"=="+a1[c]);
        }
    }


    public static void main(String[] args) {
        ArrayInitialise.intArray();
    }
}
