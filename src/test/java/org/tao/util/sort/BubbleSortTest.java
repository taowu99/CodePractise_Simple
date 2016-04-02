package org.tao.util.sort;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import org.junit.Test;

public class BubbleSortTest {
	private BubbleSort sort = new BubbleSort();

	@Test
	public void testSort() {
		//Integer[] data = new Integer[]{2,30,5,89,7,4,3};
		ArrayList<Long> data0 = new ArrayList();
		Random rnd = new Random();
		for (int i=0; i<2; i++)
			data0.add((long) (rnd.nextLong()));
		//System.out.println(data0);
		Long[] data1 = data0.toArray(new Long[]{});
		Long[] data2 = Arrays.copyOf(data1, data1.length);
		
		sort.sort(data1);
		Arrays.sort(data2);
		//System.out.println(Arrays.asList(data1));
		//System.out.println(Arrays.asList(data2));
		for (int i=0; i<data1.length; i++)
			assertTrue(data0+"; \nSort to:"+Arrays.asList(data1), data1[i].compareTo(data2[i])==0);
	}
}
