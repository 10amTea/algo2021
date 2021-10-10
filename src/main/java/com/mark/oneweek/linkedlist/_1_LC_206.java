package com.mark.oneweek.linkedlist;

/**
 * @author sun
 * @date 2021-10-07 16:08
 */
public class _1_LC_206 {
    public ListNode reverseList(ListNode head) {
        ListNode last = null; // 上一个
        while (head != null) {
            ListNode nextHead = head.next;
            head.next = last;
            last = head;
            head = nextHead;
        }
        return last;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
