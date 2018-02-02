package org.tao.leetcode;

public class DecodingSolution {
	public int numDecodings(String s) {
		if (s==null || s.length()==0)
			return 0;
		
		int[] nm= new int[s.length()+1];
		nm[s.length()]=1;
		nm[s.length()-1]=s.charAt(s.length()-1)=='0'?0:1;
		for (int i=s.length()-2; i>=0; --i)
			nm[i]=s.charAt(i)=='0'?0:(Integer.parseInt(s.substring(i, i+2))>26?nm[i+1]:(nm[i+2]+nm[i+1]));

		return nm[0];
	}
	
	public int numWithStarDecodings(String s) {
		if (s==null || s.length()==0)
			return 0;
		
		int[] nm= new int[s.length()+1];
		nm[s.length()]=1;
		nm[s.length()-1]=s.charAt(s.length()-1)=='0'?0:(s.charAt(s.length()-1)=='*'?9:1);
		for (int i=s.length()-2; i>=0; --i) {
			if (s.charAt(i)!='*') {
				nm[i]=s.charAt(i)=='0'?0:s.charAt(i+1)!='*'?(Integer.parseInt(s.substring(i, i+2))>26?nm[i+1]:(nm[i+2]+nm[i+1])):(nm[i+1]+s.charAt(i)>'2'?nm[i+2]:(s.charAt(i)>'1'?13*nm[i+2]:19*nm[i+2]));
			}else if (s.charAt(i+1)!='*') {
				nm[i]=9*nm[i+1]+(s.charAt(i+1)>'6'?nm[i+1]:s.charAt(i+1)>'0'?2*nm[i+1]:(nm[i+1]));
			}else {
				nm[i]=(1+9*2+1+6*2+73)*((i+2)<s.length()?nm[i+2]:1);
			}
		}

		return nm[0];
	}
}
