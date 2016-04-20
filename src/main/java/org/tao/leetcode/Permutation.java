package org.tao.leetcode;

import java.util.Arrays;

public class Permutation {
	public void nextPermutation(int[] nums) {
		//find the first decrease position in array
		int idxDecrease = -1;
		int i=nums.length; 
		while(--i>0) {
			if (nums[i]>nums[i-1]) {
				idxDecrease = i-1;
				break;
			}
		}
		
		//no decrease, this is already the most large permutation
		if (idxDecrease==-1) {
			Arrays.sort(nums);
			return;
		}
		
		//find the smallest element on right which is bigger than nums[idxDecrease]
		int idxSwitch = idxDecrease;
		while (++idxSwitch<nums.length) {
			if (nums[idxSwitch]<=nums[idxDecrease])
				break;
		}
		--idxSwitch;
		
		//switch
		nums[idxSwitch] = nums[idxSwitch]^nums[idxDecrease];
		nums[idxDecrease] = nums[idxSwitch]^nums[idxDecrease];
		nums[idxSwitch] = nums[idxSwitch]^nums[idxDecrease];
		
		//sort the right side to smallest
		Arrays.sort(nums, idxDecrease+1, nums.length);
    }
}
