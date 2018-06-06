package com.zhang.sort;

/**
 * 功能说明: 选择排序<br>
 * 系统版本: 2.0 <br>
 * 开发人员: zhangdl <br>
 * 开发时间: 2018/2/9 14:55<br>
 */
public class TestSimpleSelectSort {

    /**
     * 简单选择排序
     */
    public static void testSimpleSelect(){
        int[] arr={5,1,4,2};
        System.out.println("交换之前：");
        for(int num:arr){
            System.out.print(num+" ");
        }
        //选择排序的优化
        // 做第i趟排序
        for(int i = 0; i < arr.length - 1; i++) {
            int k = i;
            // 选最小的记录
            for(int j = k + 1; j < arr.length; j++){
                // k是变化的，注意
                if(arr[j] < arr[k]){
                    //记下目前找到的最小值所在的位置
                    k = j;
                }
            }
            //在内层循环结束，也就是找到本轮循环的最小的数以后，再进行交换
            //交换a[i]和a[k]
            if(i != k){
                int temp = arr[i];
                arr[i] = arr[k];
                arr[k] = temp;
            }
        }
        System.out.println("\n交换后：");
        for(int num:arr){
            System.out.print(num+" ");
        }
    }



    public static void main(String[] args) {
        TestSimpleSelectSort.testSimpleSelect();
    }

}
