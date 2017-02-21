package org.tao.leetcode;

import java.util.HashMap;

/**
 * Created by zkdu8y8 on 2/15/2017.
 */
public class NumberSolution {
    public String fractionToDecimal(int numerator, int denominator) {
        Long num = new Long(numerator);
        Long dnm = new Long(denominator);
        StringBuffer result = new StringBuffer();
        if (num<0 && dnm>0 || num>0 && dnm<0)
            result.append("-");
        num=Math.abs(num);
        dnm=Math.abs(dnm);

        result.append(num / dnm);
        num = num%dnm;
        result.append(num==0?"":".");

        HashMap<Long, Integer> cache = new HashMap<>();
        int pos = result.length()-1;

        while(num>0) {
            if (cache.containsKey(num))
                return result.insert(cache.get(num),"(").append(")").toString();

            result.append(num*10/dnm);
            cache.put(num, ++pos);
            num = num*10%dnm;
        }

        return result.toString();

    }

    public int mySqrt(int x) {
        long res = x/2;
        while (res>0 && res>x/res) {
            res = (res+x/res)/2;
        }
        return (int)res;
    }

    public int mySqrt1(int x) {
        if (x<0)
            return -1;
        else if (x==0)
            return 0;

        int left=1, right=x;

        while (left<right) {
            int mid=(left+right)/2;
            if (mid*mid==x || left==mid)
                return mid;
            else if (mid>x/mid)
                right = mid;
            else if ((mid+1)>x/(mid+1))
                return mid;
            else
                left = mid+1;
            //System.out.println(left+","+right);
        }

        return left;
    }
}
