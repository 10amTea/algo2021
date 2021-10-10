package com.mark.oneweek.homework;


/**
 * @author sun
 * @date 2021-10-10 22:48
 */
public class _2_LC_21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode protect = new ListNode(-1);
        ListNode prev = protect;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }
        prev.next = l1 == null ? l2 : l1;

        return protect.next;
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
