package org.tao.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetSolution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList());

        for (int i=0; i<nums.length; ++i) {
            int dupcount = 1;
            while (i+1<nums.length && nums[i]==nums[i+1]) {
                dupcount++;
                i++;
            }

            final int size = result.size();
            for (int k=0; k<size; ++k) {
                for (int j=0; j<dupcount; ++j) {
                    List<Integer> rst = new ArrayList<>(result.get(k));
                    for (int m=0; m<=j; ++m)
                        rst.add(nums[i]);
                    result.add(rst);
                }
            }
        }
        return result;
    }

    public List<List<Integer>> subsetsWithoutDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList());

        for (int i=0; i<nums.length; ++i) {
            final int size = result.size();
            for (int k=0; k<size; ++k) {
                List<Integer> rst = new ArrayList<>(result.get(k));
                rst.add(nums[i]);
                result.add(rst);
            }
        }
        return result;
    }
}
