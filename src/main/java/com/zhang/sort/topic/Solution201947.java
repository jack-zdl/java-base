package com.zhang.sort.topic;

import java.util.stream.Stream;

public class Solution201947 {

    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        int[] numlist = new int[2];
        for (int i = 0; i < nums.length; i ++ ){
            for (int j = i +1; j < nums.length; j ++){
                if(target == nums[i] + nums[j] ){
                    result[0] = nums[i];
                    result[1] = nums[j];
                    numlist[0] = i;
                    numlist[1] = j;
                    break;
                }
            }
        }
        return numlist;
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        nums = Solution201947.twoSum(nums,target);
        Stream.of(nums).forEach(e -> System.out.println(e.toString()));
    }
}
