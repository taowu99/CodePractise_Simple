package org.tao.hackerrank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    public static void main(String[] args) {
    	Solution s = new Solution();
    	System.out.print(s.permute(new int[]{1,2,3,4}));
    }

    private HashMap<String, List<List<Integer>>> cache= new HashMap();
    
    private String getKey(int[] nums, int from, int to) {
    	int[] numw = Arrays.copyOfRange(nums, from, to+1);
    	Arrays.sort(numw);
        StringBuffer key = new StringBuffer();
        for (int i=from-from; i<=to-from; ++i)
            key.append(numw[i]).append(",");
        //key.deleteCharAt(key.length()-1);
        return key.toString();
    }
    
    public List<List<Integer>> permute(int[] nums) {
        return permute(nums, 0, nums.length-1);
    }
    
    private List<List<Integer>> permute(int[] nums, int from, int to) {
        List<List<Integer>> result = new ArrayList();
        if (from==to) {
            List<Integer> tmp =new ArrayList<Integer>();
            tmp.add(nums[from]);
            result.add(tmp);
        }
        else {
            //Arrays.sort(nums, from, to+1);
            String key = getKey(nums, from, to);
            List<List<Integer>> cachedPerm = cache.get(key);
            if (cachedPerm==null) {
                for (int i=from; i<=to; ++i) {
                    if (i!=from) {
                        nums[from] = nums[i]^nums[from];
                        nums[i]    = nums[i]^nums[from];
                        nums[from] = nums[i]^nums[from];
                    }
                    List<List<Integer>> subres = permute(nums, from+1, to);
                    for (List<Integer> one : subres) {
                    	ArrayList nw = new ArrayList(one);
                        nw.add(0, nums[from]);
                        result.add(nw);
                    }
                    if (i!=from) {
                        nums[from] = nums[i]^nums[from];
                        nums[i]    = nums[i]^nums[from];
                        nums[from] = nums[i]^nums[from];
                    }
                }
                cache.put(key, result);
            }
            else
                return cachedPerm;
        }
        return result;
    }
}