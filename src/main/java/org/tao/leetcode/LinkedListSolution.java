package org.tao.leetcode;

/**
 * Created by Tao Wu on 10/19/2016.
 */

public class LinkedListSolution {
    public boolean hasCycle(ListNode head) {
        ListNode node1=head, node2=head;
        while (node2 != null && node1 !=null) {
            node1 = node1.next;
            node2 = node2.next==null? null:node2.next.next;
            if (node1==node2 && node2 != null)
                return true;
        }
        return false;
    }

    public ListNode detectCycle(ListNode head) {
        ListNode node1=head, node2=head;
        while (node2 != null && node1 !=null) {
            node1 = node1.next;
            node2 = node2.next==null? null:node2.next.next;
            if (node1==node2 && node2 != null) {
                ListNode node3=head;
                while (node3!=node2) {
                    node2 = node2.next;
                    node3 = node3.next;
                }
                return node3;
            }
        }
        return null;
    }

    public ListNode sortListWithMergeSort(ListNode head) {
        //sort linked list in nlog(n) with constant space
        if (head==null || head.next==null)
            return head;

        int len=1;
        ListNode tmp = head;
        while ((tmp=tmp.next) != null)
            ++len;

        ListNode mid = head;
        int cnt=len/2;
        while (--cnt>0)
            mid=mid.next;
        tmp = mid.next;
        mid.next = null;
        mid = tmp;

        head = sortListWithMergeSort(head);
        mid = sortListWithMergeSort(mid);

        ListNode newHead = new ListNode(0);
        tmp = newHead;
        while (head!=null && mid!=null) {
            tmp.next = head.val<mid.val?head:mid;
            head = tmp.next==head?head.next:head;
            mid = tmp.next==mid?mid.next:mid;
            tmp = tmp.next;
        }
        tmp.next = head!=null?head:mid;
        return newHead.next;
    }

    public ListNode sortListWithQuickSort(ListNode head) {
        //sort linked list in nlog(n) with constant space
        if (head==null || head.next==null)
            return head;

        ListNode pivot = head;

        ListNode leftHead=new ListNode(0), rightHead=new ListNode(0);
        ListNode leftTail = leftHead, rightTail = rightHead;
        ListNode tmp = head.next;
        while (tmp != null) {
            if (tmp.val < pivot.val )
                leftTail = (leftTail.next = tmp);
            else
                rightTail = (rightTail.next=tmp);
            tmp = tmp.next;
        }
        leftTail.next = null;
        rightTail.next = null;

        leftHead.next = sortListWithQuickSort(leftHead.next);
        rightHead.next = sortListWithQuickSort(rightHead.next);

        tmp = leftHead;
        while (tmp.next!=null)
            tmp = tmp.next;
        tmp.next = pivot;
        pivot.next = rightHead.next;

        return leftHead.next;
    }

    public void reorderList(ListNode head) {
        if (head==null || head.next==null)
            return;

        //find mid
        ListNode mid=head, tmp=head;
        while(tmp.next!=null && tmp.next.next!=null) {
            mid=mid.next;
            tmp=tmp.next.next;
        }

        //reverse the second half
        tmp=mid.next;
        ListNode prv = null, t;
        while (tmp !=null) {
            t = tmp.next;
            tmp.next = prv;
            prv = tmp;
            tmp = t;
        }
        mid.next =null;

        //reorder
        ListNode tmp1 = head, tmp2=prv;
        while (tmp2!=null) {
            t = tmp1.next;
            tmp1.next = tmp2;
            tmp1 = t;
            t = tmp2.next;
            tmp2.next = tmp1;
            tmp2 = t;
        }
    }
}
