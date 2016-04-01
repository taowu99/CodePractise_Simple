package org.tao.test.simpletest;

import java.util.HashSet;
import java.util.Scanner;

public class TwoStrings {
	
	public void checkTwoStrings() {
		//int groupnumber = Integer.parseInt(System.console().readLine("group Number"));
		Scanner sc=new Scanner(System.in);
        int groupnumber=sc.nextInt();
		for (int i=0; i< groupnumber; i++) {
			//String s1 = System.console().readLine();
			//String s2 = System.console().readLine();
			String s1 = sc.next();
			String s2 = sc.next();
			
			HashSet s1set = new HashSet();
			for (char c : s1.toCharArray()) {
				s1set.add(c);
				///if we know the super set of all possible char, we can break loop here when all char shows up
			}
			HashSet s2set = new HashSet();
			for (char c : s2.toCharArray()) {
				s2set.add(c);
				///if we know the super set of all possible char, we can break loop here when all char shows up
			}
			
			s1set.retainAll(s2set);
			if (s1set.isEmpty())
				System.out.println("NO");
			else
				System.out.println("YES");
		}
	}

}
