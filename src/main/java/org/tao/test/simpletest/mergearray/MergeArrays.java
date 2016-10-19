package org.tao.test.simpletest.mergearray;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

import org.tao.util.datastructure.Heap;

import com.google.common.collect.ImmutableList;

public class MergeArrays {
	public void merge(int[] nums1, int m, int[] nums2, int n) {
		int idx2 = 0;
		int idx1 = 0;
		int len1 = m;
		while (idx2 < n) {
			int isrt = nums2[idx2];
			while (nums1[idx1] <= isrt && idx1<len1) {
				idx1++;
			}
			len1 = insert(nums1, len1, isrt, idx1);
			idx2++;
		}
		
    }
	
	public int insert(int[] space, int len, int isrt, int pos) {
		if (pos<0)
			pos=0;
		if (pos>len)
			pos=len;
		
		for (int i=len-1; i>=pos; --i) {
			space[i+1] =space[i];
		}
		space[pos] = isrt;
		
		return len+1;
	}
	
	public ListNode mergeKLists(ListNode[] lists) {
		ListNode result =null, root=null;
		if (lists == null || lists.length==0)
		    return root;
		    
		Comparator<ListNode> cmp = new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val-o2.val;
        }};
        
		PriorityQueue<ListNode> cache = new PriorityQueue(lists.length, cmp);
		for (ListNode node : lists)
		    if (node!=null)
		        cache.add(node);
		
		while(!cache.isEmpty()) {
			ListNode nd = cache.poll();
			if (nd.next != null) {
				cache.add(nd.next);
			    nd.next = null;
			}
			if (root == null) {
				root = nd;
				result = root;
			}
			else {
				result.next = nd;
				result = result.next;
			}
		}
		
        return root;
    }
	
	public static void main(String[] args) {
		MergeArrays ma = new MergeArrays();
		List<List<Integer>> in = ImmutableList.of(
			ImmutableList.of(1,2,3),
			ImmutableList.of(5,6,167),
			ImmutableList.of(6,15,16,27),
			ImmutableList.of(7,26,97)
		);

		ArrayList<ListNode> inputs = new ArrayList();
		for (List<Integer> inp : in) {
			//final ListNode il = new ListNode(-1);
			//inp.forEach((data)->{il.next = new ListNode(data); });
			ListNode il = null, root=null;
			for (Integer data : inp)
				if (il==null) {
					il=new ListNode(data);
					root=il;
				}
				else {
					il.next=new ListNode(data);
					il=il.next;
				}
			inputs.add(root);
			il.next = null;
		}
		
		ListNode res = ma.mergeKLists(inputs.toArray(new ListNode[]{}));
		while (res!=null) {
			System.out.print(res.val+" ");
			res=res.next;
		}
	}
}
