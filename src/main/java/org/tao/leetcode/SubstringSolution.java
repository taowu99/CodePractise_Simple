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

    public String getMaxSubOf2Char(String data) {
        String result="";
        if (data==null || data.length() ==0)
            return result;

        LinkedHashMap<Character, Integer> charPos=new LinkedHashMap<Character, Integer>(2) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<Character,Integer> eldest) {
                return 2<size();
            }
        };
        for (int idxA=0, idxE=0; idxE<data.length(); ++idxE) {
            if (!charPos.containsKey(data.charAt(idxE)) && charPos.size()==2){
                final Character c = data.charAt(idxE-1);
                idxA = charPos.entrySet().stream().filter(k-> !k.equals(c)).findFirst().get().getValue()+1;
            }
            charPos.remove(data.charAt(idxE));
            charPos.put(data.charAt(idxE), idxE);
            if (result.length() < (idxE - idxA +1) ) result = data.substring(idxA, idxE+1);
        }

        return result;
    }

    public String getMaxSubOf2Char_v2(String data) {
        String result="";
        if (data==null || data.length() ==0)
            return result;

        Map<Character, Integer> keyIndex=new HashMap<>();
        for (int idxA=0, idxE=0; idxE<data.length(); ++idxE) {

            if (keyIndex.size()==2 && !keyIndex.containsKey(data.charAt(idxE))) {
                for (Map.Entry<Character, Integer> pair : keyIndex.entrySet())
                    if (!pair.getKey().equals(data.charAt(idxE - 1))) {
                        idxA = pair.getValue() + 1;
                        keyIndex.remove(pair.getKey());
                        break;
                    }
            }
            keyIndex.put(data.charAt(idxE), idxE);
            if (result.length() < (idxE - idxA +1) ) result = data.substring(idxA, idxE+1);
        }

        return result;
    }

    public String getMaxSubOf2Char_v1(String data) {
        String result="";
        if (data==null || data.length() ==0)
            return result;

        Map<Character, Integer> keyIndex=new HashMap<>();
        for (int idxA=0, idxE=0; idxE<data.length(); ++idxE) {
            keyIndex.put(data.charAt(idxE), idxE);

            if (keyIndex.size()>2) {
                List<Character> nxt = Arrays.asList(new Character[]{data.charAt(idxE - 1), data.charAt(idxE)});
                for (Map.Entry<Character, Integer> pair : keyIndex.entrySet())
                    if (!nxt.contains(pair.getKey())) {
                        idxA = pair.getValue() + 1;
                        keyIndex.remove(pair.getKey());
                        break;
                    }
            }
            if (result.length() < (idxE - idxA +1) ) result = data.substring(idxA, idxE+1);
        }

        return result;
    }

    public String getMaxSubOfDistinctChar(String data, int numberOfDistinctChars) {
        String result="";

        LinkedHashMap<Character, Integer> charPos=new LinkedHashMap<Character, Integer>(2) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<Character,Integer> eldest) {
                return numberOfDistinctChars<size();
            }
        };
        for (int idxA=0, idxE=0; idxE<data.length(); ++idxE) {
            if (!charPos.containsKey(data.charAt(idxE)) && charPos.size()==numberOfDistinctChars){
                final Character c = data.charAt(idxE-1);
                idxA = charPos.entrySet().stream().filter(k-> !k.equals(c)).findFirst().get().getValue()+1;
            }
            charPos.remove(data.charAt(idxE));
            charPos.put(data.charAt(idxE), idxE);
            if (result.length() < (idxE - idxA +1) ) result = data.substring(idxA, idxE+1);
        }

        return result;
    }
	
	public static void main(String[] args) {
        Map<Integer, Integer> cache = new HashMap();
		"abcabcCcCCx".chars().forEach(c->cache.merge(c, 1, (x,y) -> x == null? y: x+y));
		System.out.println(cache);
		cache.computeIfPresent((int)'x', (k,v)->--v);
		System.out.println(cache);
	}
}
