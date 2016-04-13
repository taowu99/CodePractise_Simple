package org.tao.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombination {
    private final Map<String, List<String>> numToltr = new HashMap();
    
	public LetterCombination() {
		numToltr.put("2", Arrays.asList("a", "b", "c"));
		numToltr.put("3", Arrays.asList("d", "e", "f"));
		numToltr.put("4", Arrays.asList("g", "h", "i"));
		numToltr.put("5", Arrays.asList("j", "k", "l"));
		numToltr.put("6", Arrays.asList("m", "n", "o"));
		numToltr.put("7", Arrays.asList("p", "q", "r", "s"));
		numToltr.put("8", Arrays.asList("t", "u", "v"));
		numToltr.put("9", Arrays.asList("w","x","y","z"));
    }
    
	public List<String> letterCombinations(String digits) {
        
        List<String> res = new ArrayList<String>();
        if (digits==null || digits.length()==0)
        	return res;
        
        List<String> combs = numToltr.get(digits.charAt(0)+"");
        String oth = digits.length()>1?digits.substring(1):null;
        if (combs!=null && combs.size()>0)
			for (String ch : combs) {
				List<String> othCombs = letterCombinations(oth);
				if (othCombs!=null && !othCombs.isEmpty())
					for (String cmb : othCombs)
						res.add(ch + cmb);
				else
					res.add(ch);
			}
        else
        	for (String cmb : letterCombinations(oth))
				res.add(cmb);
        
        return res;
    }
}
