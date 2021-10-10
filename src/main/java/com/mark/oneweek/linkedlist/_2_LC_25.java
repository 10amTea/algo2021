package com.mark.oneweek.linkedlist;

/**
 * @author sun
 * @date 2021-10-07 16:35
 */
public class _2_LC_25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode protect = new ListNode(0, head);
        ListNode last = protect;
        while (head != null) {
            // 1、分组head&&end
            ListNode end = getEnd(head, k);
            if (end == null) {
                break;
            }
            ListNode nextGroupHead = end.next;

            // 2、内部反转
            reverseList(head, nextGroupHead);

            // 3、更新每组前一组和后一组之间的边
            last.next = end;
            head.next = nextGroupHead;

            last = head;
            head = nextGroupHead;
        }
        return protect.next;
    }

    // 返回走k-1步之后的点
    // 返回null表示不够k个
    private ListNode getEnd(ListNode head, int k) {
        while (head != null) {
            k--;
            if (k == 0) {
                return head;
            }
            head = head.next;
        }
        return null;
    }

    private void reverseList(ListNode head, ListNode stop) {
        ListNode last = head;
        head = head.next;
        while (head != stop) {
            ListNode nextHead = head.next;
            head.next = last;
            last = head;
            head = nextHead;
        }
    }
}
