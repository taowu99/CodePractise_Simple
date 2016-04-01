package org.tao.test.simpletest;

import java.util.ArrayList;
import java.util.List;

public class Palindrome {
    
    public boolean isPalindrome(String word) {
        for (int i=0; i< word.length()/2; i++) {
        	if (word.charAt(i) != word.charAt(word.length()-1-i)) {
        		return false;
        	}
        }
        
        return true;
    }
    
    public boolean isPalindrome(String word1, String word2) {
        for (int i=0; i< (word1.length()+word2.length())/2; i++) {
        	final char char1 = i<word1.length()?word1.charAt(i):word2.charAt(i-word1.length());
        	final int idx2 = word2.length()+word1.length()-1-i;
        	final char char2 = (idx2)<word1.length()?word1.charAt(idx2):word2.charAt(idx2-word1.length());
        	if (char1 != char2) {
        		return false;
        	}
        }
        
        return true;
    }
    
    public List<List<Integer>> palindromePairs(String[] words) {
        List result = new ArrayList();
        for (int i=0; i<words.length; i++) {
            for (int j=i+1; j<words.length; j++) {
                if (isPalindrome(words[i], words[j])){ 
                    ArrayList a = new ArrayList();
                    a.add(i);
                    a.add(j);
                    result.add(a);
                }
                if (isPalindrome(words[j], words[i])){ 
                    ArrayList a = new ArrayList();
                    a.add(j);
                    a.add(i);
                    result.add(a);
                }
            }
        }
        return result;
    }
}
