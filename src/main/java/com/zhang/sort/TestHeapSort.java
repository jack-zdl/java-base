package com.zhang.sort;

/**
 * 功能说明: 堆排序<br>
 * 系统版本: 2.0 <br>
 * @author : zhangdl <br>
 * 开发时间: 2018/2/9 17:30<br>
 */
public class TestHeapSort {

    public static void main(String[] args) {
        int[] arr = { 50, 10, 90, 30, 70, 40, 80, 60, 20 };
        System.out.println("排序之前：");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.printf("开始排序");
        // 堆排序
        heapSort(arr);

        System.out.println("\n"+"排序之后：");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

    }

    /**
     * 堆排序
     */
    private static void heapSort(int[] arr) {
        // 将待排序的序列构建成一个大顶堆
        //第一个非叶子结点 arr.length/2-1=5/2-1=1
        for (int i = arr.length / 2 -1; i >= 0; i--){
            heapAdjust(arr, i, arr.length);
        }
        // 初始构建最大堆
        for (int i1 = 0; i1 < arr.length; i1++) {
            System.out.print("\r\n"+arr[i1] + " ");
        }

        // 逐步将每个最大值的根节点与末尾元素交换，并且再调整二叉树，使其成为大顶堆
        for (int i = arr.length - 1; i > 0; i--) {
            // 将堆顶记录和当前未经排序子序列的最后一个记录交换==将最大堆顶点跟数组最后一位交换
            swap(arr, 0, i);
            // 交换之后，需要重新检查堆是否符合大顶堆，不符合则要调整
            heapAdjust(arr, 0, i);
        }
    }

    /**
     * 构建堆的过程
     * 其实就是便利所有的非叶子节点，保证
     * @param arr 需要排序的数组
     * @param i 需要构建堆的根节点的序号
     * @param n 数组的长度
     */
    private static void heapAdjust(int[] arr, int i, int n) {
        int child;
        int father;
        for (father = arr[i]; leftChild(i) < n; i = child) {
            child = leftChild(i);

            /**
             * child != n-1 孩子节点不等于最后一个，最后一个没有右节点
             *
             * 先比较孩子节点的最大节点，然后再和父节点比较
             */
            // 如果左子树小于右子树，则需要比较右子树和父节点
            if (child != n - 1 && arr[child] < arr[child + 1]) {
                child++; // 序号增1，指向右子树
            }

            // 如果父节点小于孩子结点，则需要交换
            if (father < arr[child]) {
                arr[i] = arr[child];
            } else {
                break; // 大顶堆结构未被破坏，不需要调整
            }
        }
        arr[i] = father;
    }

    // 获取到左孩子结点

    /**
     * 左孩子节点为数组的2*n+1 ,右孩子节点为2*n+1 +1 = 左孩子节点+1
     * @param i
     * @return
     */
    private static int leftChild(int i) {
        return 2 * i + 1;
    }

    // 交换元素位置

    /**
     *  交换位置
     * @param arr
     * @param index1
     * @param index2
     */
    private static void swap(int[] arr, int index1, int index2) {
        int tmp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = tmp;
    }
}
