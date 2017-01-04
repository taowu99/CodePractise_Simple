package org.tao.leetcode;

import java.util.HashMap;
import java.util.Map;

public class SubstringSolution {
	String minWindow(String s, String t) {
        Map<Integer, Integer> cache = new HashMap();
        t.chars().forEach(c->cache.merge(c, 1, (x,y) -> x == null? y: x+y));
        int begin=0, end=0, d=Integer.MAX_VALUE, head=0;
        Integer counter=new Integer(t.length());
        while(end<s.length()){
        	char c = s.charAt(end++);
            if (cache.containsKey((int)c)) {
                if (cache.get((int)c)>0)
                    counter--;
                cache.compute((int) c, (k,v)->--v);
            }
            while(counter==0){
                if(end-begin<d)
                    d=end-(head=begin);
                char c2=s.charAt(begin++);
                if (cache.containsKey((int)c2)) {
                    if (cache.get((int)c2)==0)
                        counter++;
                    cache.compute((int) c2, (k,v)->++v);
                }
            }  
        }
        return d==Integer.MAX_VALUE? "":s.substring(head, d+head);
    }
	
	public static void main(String[] args) {
        Map<Integer, Integer> cache = new HashMap();
		"abcabcCcCCx".chars().forEach(c->cache.merge(c, 1, (x,y) -> x == null? y: x+y));
		System.out.println(cache);
		cache.computeIfPresent((int)'x', (k,v)->--v);
		System.out.println(cache);
	}
}
