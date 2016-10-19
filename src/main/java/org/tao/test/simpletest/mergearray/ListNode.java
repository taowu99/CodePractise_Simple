package org.tao.test.simpletest.mergearray;

public class ListNode implements Comparable {
	int val;
	ListNode next;
	ListNode(int x) { val = x; }
	@Override
	public int compareTo(Object o) {
		ListNode lo = (ListNode)o;
		return this.val - lo.val; 
	}
}