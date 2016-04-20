package org.tao.leetcode;

import java.util.ArrayList;
import java.util.List;

public class ParentheseCombination {
	public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList();
        
        generate(n,n,result, "");
        return result;
    }
    
    private void generate(int leftCount, int rightCount, List<String> result, String prefix) {
    	if (leftCount>0) {
    		generate(leftCount-1, rightCount, result, prefix+"(");
    		if (rightCount>leftCount)
    			generate(leftCount, rightCount-1, result, prefix+")");
    	}
    	else if (rightCount>0) {
    		generate(leftCount, rightCount-1, result, prefix+")");
    	}
    	else
    		result.add(prefix);
    }
}
