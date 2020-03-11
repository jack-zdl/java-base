package com.zhang.sort.topic;

import com.google.common.collect.Sets;

import java.util.*;
import java.util.stream.Collectors;

/**
 *  两个数组的交集
 */
public class Solution2019626 {

    public static Set intersection(int[] nums1, int[] nums2) {
//        List list =  Arrays.asList(1,2,2,1);
        Set targetSet = Sets.newHashSet(nums1);

        Set set1 = Sets.newHashSet(nums1);
//        Set set = Sets.newHashSet(nums1);
//        set1.addAll(Arrays.asList(nums1));
//        set1.add(1);set1.add(2);set1.add(2);set1.add(1);
        Set set2 = Sets.newHashSet(nums2);
//        set2.add(2);set2.add(2);
//        set2.addAll(Arrays.asList(nums2));
        Set sameSet = new HashSet();
        set1.stream().forEach(x ->{
            sameSet.addAll((Collection) set2.stream().filter(s -> s == x).collect(Collectors.toSet()));
        });
        return sameSet;

    }

    public static void main(String[] args) {
        int[] nums1,nums2;
        nums1 = new int[] {1,2,2,1};
        nums2 = new int[]{2,2};
        Set set = intersection(nums1,nums2);
        System.out.println(set.toString());
    }
}
