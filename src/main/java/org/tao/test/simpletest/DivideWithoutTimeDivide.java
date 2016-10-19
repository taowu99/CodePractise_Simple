package org.tao.test.simpletest;

public class DivideWithoutTimeDivide {
	public int divide(int dividend, int divisor)  {
        if (dividend == 0)
            return 0;
        if (divisor == 1)
            return (int)dividend;
        
        int sig = -1;
        if ((dividend>0) && (divisor>0) || (dividend<0) && (divisor<0))
            sig = 1;
        
        if (((long)divisor)<Integer.MIN_VALUE)
        	return 0;
        if (((long)divisor)>Integer.MAX_VALUE)
        	return 0;

        if (((long)dividend)<Integer.MIN_VALUE || ((long)dividend)>Integer.MAX_VALUE)
        	return sig>0?Integer.MAX_VALUE:Integer.MIN_VALUE;

        if (divisor == -1) {
        	long rs = (-1)*(int)dividend;
        	if (rs>Integer.MAX_VALUE)
        		return Integer.MAX_VALUE;
        }
        
        long dvd = Math.abs((long)dividend);
        long dsr = Math.abs((long)divisor);
        if (dvd<dsr)
        	return 0;
        
        long res =1;
        while (dvd>=dsr) {
        	dsr=dsr<<1;
        	res = res<<1;
        }
        dsr = dsr>>1;
        res = res>>1;
        dvd -=dsr;
        //res++;
        
        if (dvd>Math.abs(divisor))
        	res +=new Long((divide((int)dvd, Math.abs(divisor))));
        
        if (res>Integer.MAX_VALUE)
        	return Integer.MAX_VALUE;
        
        return sig*(int)res;
    }
}
