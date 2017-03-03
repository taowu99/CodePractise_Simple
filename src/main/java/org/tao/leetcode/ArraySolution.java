package org.tao.leetcode;

public class ArraySolution {
    public int jump0(int[] nums) {
        int steps = 0;
        int lastJump =0;
        int maxJump = 0;
        for (int i=0; i<nums.length-1; ++i) {
            maxJump=Math.max(nums[i], maxJump-1);
            if (--lastJump<=0) {
                lastJump = maxJump;
                steps++;
            }
        }

        return steps;
    }

    public int jump(int[] nums) {
        int steps = 0, cacheStart = 0, cacheEnd=0;

        while (cacheStart<=cacheEnd && cacheEnd<nums.length-1) {
            int maxJumpTo = 0;
            for (int i=cacheStart; i<=cacheEnd; ++i)
                maxJumpTo = Math.max(nums[i]+i, maxJumpTo);
            ++steps;
            cacheStart = cacheEnd+1;
            cacheEnd = maxJumpTo;
        }
        return steps;
    }

    public void rotate2(int[] nums, int k) {
        if (k==0)
            return;
        final int len = nums.length;
        k=(len+k)%len;
        int cnt=0;
        int start = 0;
        while (cnt<len) {
            int step = start;
            int valu = nums[start];
            do {
                step = step+k <len?(step+k):(step+k-len);
                nums[step] = nums[step]^valu;
                valu = nums[step]^valu;
                nums[step] = nums[step]^valu;
                cnt++;
            }while (step!=start);
            start++;
        }
    }

    public void rotate(int[] nums, int k) {
        if (k==0)
            return;
        final int len = nums.length;
        k=(len+k)%len;
        int start = 0;
        final int stp = findGcd(len,k);
        for (int i=0; i<stp; i++) {
            int step = start;
            int valu = nums[start];
            do {
                step = step+k <len?(step+k):(step+k-len);
                nums[step] = nums[step]^valu;
                valu = nums[step]^valu;
                nums[step] = nums[step]^valu;
            }while (step!=start);
            start++;
        }
    }

    public int findGcd(int a, int b){
        return (a == 0 || b == 0) ? a + b : findGcd(b, a % b);
    }

    public void rotate1(int[] nums, int k) {
        if (k==0)
            return;
        final int len = nums.length;
        k=(len+k)%len;
        rotate(nums, 0,nums.length-k-1);
        rotate(nums, nums.length-k,nums.length-1);
        rotate(nums, 0,nums.length-1);
    }

    public void rotate(int[] nums, int bgn, int end) {
        while (bgn<end) {
            nums[bgn]=nums[bgn]^nums[end];
            nums[end]=nums[bgn]^nums[end];
            nums[bgn]=nums[bgn++]^nums[end--];
        }
    }

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
