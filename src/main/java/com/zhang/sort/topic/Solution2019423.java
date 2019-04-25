package com.zhang.sort.topic;

import org.junit.Before;
import org.junit.Test;

/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 */
public class Solution2019423 {

    /**
     * 采用递归的思想
     * @param l1
     * @param l2
     * @return
     */
    public  ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode node1 = l1;
        ListNode node2 = l2;
        // 寻找长的list
        while(node1 != null && node2 != null) {
            node1 = node1.next;
            node2 = node2.next;
        }
        // 判断长度
        if(node2 == null) {
            node1 = l1;
            node2 = l2;
        } else {
            node1 = l2;
            node2 = l1;
        }
        ListNode result = new ListNode(0);
        ListNode node = result;
        // node2 是较短的那个(可能同样长)
        while(node2 != null) {
            // 求和
            int sum = node1.val + node2.val + node.val;
            node.val = sum % 10;
            // 进位
            int mod = sum / 10;
            if(mod > 0 || node1.next != null) {
                node.next = new ListNode(mod);
                node = node.next;
            }
            // 后移
            node1 = node1.next;
            node2 = node2.next;
        }
        while(node1 != null) {
            // 求和
            int sum = node1.val + node.val;
            node.val = sum % 10;
            // 进位
            int mod = sum / 10;
            if(mod > 0 || node1.next != null) {
                node.next = new ListNode(mod);
                node = node.next;
            }
            node1 = node1.next;
        }
        return result;
    }

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    private ListNode listNode;
    private ListNode l2;
    @Before
    public void before(){
        listNode = new ListNode(1);
//        listNode.next = new ListNode(4);
//        listNode.next.next = new ListNode(3);
        l2 = new ListNode(9);
        l2.next = new ListNode(9);
//        l2.next.next = new ListNode(4);
//        l2.next.next.next =new ListNode(6);
    }

    @Test
    public void Test(){
        ListNode result = addTwoNumbers(listNode,l2);
        System.out.println("l1 ="+result);
    }
}
