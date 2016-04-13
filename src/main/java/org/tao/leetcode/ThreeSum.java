package org.tao.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
	public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        ArrayList<List<Integer>> res = new ArrayList();
        int l = nums.length;
        for (int i=0; i< l-2; ++i) {
        	int a=i+1, e=l-1;
        	while (a<e) {
        		final int sum = nums[i]+nums[a]+nums[e];
        		if (sum==0) {
        			res.add(Arrays.asList(nums[i],nums[a],nums[e]));
        			do {
        				++a;
        			}while (a<l && nums[a]==nums[a-1]);
        			do {
        				--e;
        			}while (e>=0 && nums[e]==nums[e+1]);
        		}
        		else if (sum<0)
        			++a;
        		else
        			--e;
        	}
        	while (i<l-2 && nums[i]==nums[i+1])
        		++i;
        }
        
        return res;
    }
	
	public int threeSum(int[] nums, int target) {
		int closest = Integer.MAX_VALUE;
        Arrays.sort(nums);
        int l = nums.length;
        for (int i=0; i< l-2; ++i) {
        	int a=i+1, e=l-1;
        	while (a<e) {
        		final int sum = nums[i]+nums[a]+nums[e];
        		if (Math.abs(sum-target)<Math.abs(closest==Integer.MAX_VALUE?closest:closest-target))
        			closest = sum;
        		if (sum==target) {
        			return target;
        		}
        		else if (sum<target)
        			++a;
        		else
        			--e;
        	}
        	while (i<l-2 && nums[i]==nums[i+1])
        		++i;
        }
        
        return closest;
    }
}
