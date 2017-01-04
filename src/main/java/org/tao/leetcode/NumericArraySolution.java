package org.tao.leetcode;

public class NumericArraySolution {
	static public int findMaxSubarray(int[] array) {
		long maxSum=Integer.MIN_VALUE;
		
		if (array==null || array.length==0)
			return 0;
		
		long curSum=maxSum;
		for (int data : array) {
			curSum=Math.max(curSum+data, data);
			maxSum=Math.max(curSum, maxSum);
		}
		
		return (int) Long.max(Integer.MIN_VALUE,maxSum);
	}

	public int majorityElement(int[] nums) {
		int maj = nums[0];
		int cnt=1;
		for (int i=1; i< nums.length; ++i) {
			if (cnt==0)
				maj = nums[i];

			cnt += nums[i]==maj?1:-1;
		}

		return maj;
	}
}
