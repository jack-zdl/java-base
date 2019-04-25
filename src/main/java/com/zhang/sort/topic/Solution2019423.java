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

        ListNode node = new ListNode(0);
        if((l1 == null || l1.next == null )&& (l2 == null || l2.next == null)){
            if(l1 == null){
                l1 = new ListNode(0);
            }else if(l2 == null) {
                l2 = new ListNode(0);
            }
            int a = l1.val+l2.val;
            int  remainder = a % 10 ;
            int result  = a / 10;
            node.next = new ListNode(remainder);
            node.val = result;
            return node;  // 余数
        }else {
            ListNode val = addTwoNumbers(l1.next,l2.next);
            int b = val.val + l1.val + l2.val;
           int  remainder = b % 10 ;
           int result  = b / 10;
            if(l1.next == null){
                l1.next = new ListNode(0);
            }
            val.val = remainder ;
            val.next.val = val.next.val +result;
            node.next = val;
            return node;
        }
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
        listNode = new ListNode(6);
        listNode.next = new ListNode(6);
        listNode.next.next = new ListNode(6);
        l2 = new ListNode(6);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(6);
        l2.next.next.next =new ListNode(6);
    }

    @Test
    public void Test(){
        ListNode result = addTwoNumbers(listNode,l2);
        System.out.println("l1 ="+listNode);
    }
}
