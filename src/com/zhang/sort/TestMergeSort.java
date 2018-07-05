package com.zhang.sort;

/**
 * 功能说明:  归并排序  <br>
 * 系统版本: 2.0 <br>
 * 开发人员: zhangdl <br>
 * 开发时间:2018/7/5 16:15<br>
 * <br>
 */
public class TestMergeSort {

    public  void mergeSort(int[] a, int left, int right) {
        int t = 1;// 每组元素个数
        int size = right - left + 1;
        while (t < size) {
            int s = t;// 本次循环每组元素个数
            t = 2 * s;
            int i = left;
            while (i + (t - 1) < size) {
                merge(a, i, i + (s - 1), i + (t - 1));
                i += t;
            }
            if (i + (s - 1) < right){
                merge(a, i, i + (s - 1), right);
            }
        }
    }

    private static void merge(int[] data, int p, int q, int r) {
        int[] B = new int[data.length];
        int s = p;
        int t = q + 1;
        int k = p;
        while (s <= q && t <= r) {
            if (data[s] <= data[t]) {
                B[k] = data[s];
                s++;
            } else {
                B[k] = data[t];
                t++;
            }
            k++;
        }
        if (s == q + 1){
            B[k++] = data[t++];
        } else{
            B[k++] = data[s++];
        }
        for (int i = p; i <= r; i++){
            data[i] = B[i];
        }
    }
}
