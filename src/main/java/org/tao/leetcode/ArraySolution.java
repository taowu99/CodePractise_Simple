package org.tao.leetcode;

public class ArraySolution {

    public int missingNumber(int[] nums) {
        for (int idx=0; idx<nums.length; ++idx) {
            while ((nums[idx]!=idx) && (nums[idx]<nums.length)) {
            	int temp = nums[idx];
                nums[idx] = nums[nums[idx]];
                nums[temp] = temp;
            }
        }
        
        for (int idx=0; idx<nums.length; ++idx)
            if (nums[idx]!=idx)
                return idx;
                
        return nums.length;
    }
}
