package org.tao.leetcode;

/**
 * Created by zkdu8y8 on 8/15/2016.
 */
public class NodeListSolution {
    public ListNode reverseList(ListNode head) {
        ListNode prv = null;
        ListNode ptr = head;
        while (ptr!=null) {
            ListNode nxt = ptr.next;
            ptr.next = prv;
            prv = ptr;
            ptr = nxt;
        }
        return prv;
    }

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (m<1 || m>=n || n<=1)
            return head;

        ListNode prev = new ListNode(Integer.MIN_VALUE);
        prev.next = head;
        int cnt =m;
        while (--cnt>0 && prev!=null)
            prev = prev.next;
        ListNode curr = prev.next;

        ListNode bfr = prev;
        ListNode tail = curr;
        for (int i=m; i<=n; ++i) {
            ListNode nxt = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nxt;
        }
        bfr.next = prev;
        tail.next = curr;

        return m==1? prev:head;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k<=1)
            return head;

        ListNode prev=head;
        for (int i=0; i<k-1; ++i)
            if ((prev=prev.next)==null)
                return head;

        ListNode ptr = head;
        prev=null;
        for (int i=0; i<k; ++i) {
            ListNode nxt = ptr.next;
            ptr.next = prev;
            prev = ptr;
            ptr = nxt;
        }

        head.next = reverseKGroup(ptr, k);

        return prev;
    }
}
