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
}
