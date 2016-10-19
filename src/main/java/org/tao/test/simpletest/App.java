package org.tao.test.simpletest;

import java.util.ArrayList;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        //System.out.println( "Hello World!" );
        //TwoStrings ts = new TwoStrings();
        //ts.checkTwoStrings();
        
    	long aa=1_2_333;
    	Palindrome x = new Palindrome();
    	System.out.println(x.isPalindrome("abbeba"));
    	System.out.println(x.isPalindrome("abbba"));
    	System.out.println(x.isPalindrome("abbebe"));
    	ArrayList a = new ArrayList();
    	x.palindromePairs(new String[]{"abcd", "dcba", "lls", "s", "sssll"});
    }
}
