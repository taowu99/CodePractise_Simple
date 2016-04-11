package org.tao.leetcode;

public class RomanNumbers {

    public String intToRoman(int num) {
        String[] romans = new String[]{"I","V","X","L","C","D","M","",""};
        if (num<1 || num>3999)
            return null;
        
        StringBuffer romanNumber = new StringBuffer();
        int tst = num, div=1000;
        for (int i=3; i>=0; --i) {
            int dgt = tst/div;
            tst -=dgt*div;
            div=div/10;
            if (dgt==0)
            	continue;
            int idx = i*2;
            romanNumber.append(oneBitToRoman(dgt, romans[idx], romans[idx+1], romans[idx+2]));
        }
        return romanNumber.toString();
    }
    
    private String oneBitToRoman(int onedit, String one, String five, String ten) {
        StringBuffer res= new StringBuffer();
        if (onedit>=10)
            return "";
        switch(onedit) {
            case 3:
                res.append(one);
            case 2:
                res.append(one);
            case 1:
                res.append(one);
                break;
            case 4:
                res.append(one).append(five);
                break;
            case 8:
                res.append(one);
            case 7:
                res.append(one);
            case 6:
                res.append(one);
            case 5:
                res.insert(0,five);
                break;
            case 9:
                res.append(one).append(ten);
                break;
        }
        
        return res.toString();
    }
}
