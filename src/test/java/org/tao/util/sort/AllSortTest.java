package org.tao.util.sort;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.junit.Test;

public class AllSortTest {

	@Test
	public void testBubbleSort() {
		BubbleSort sort = new BubbleSort();
		
		//Integer[] data = new Integer[]{2,30,5,89,7,4,3};
		ArrayList<Long> data0 = new ArrayList();
		Random rnd = new Random();
		for (int i=0; i<1000; i++)
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

	@Test
	public void testInsertionSort() {
		InsertionSort sort = new InsertionSort();
		
		//Integer[] data = new Integer[]{2,30,5,89,7,4,3};
		List<Comparable> data0 = new ArrayList();
		Random rnd = new Random();
		for (int i=0; i<1000; i++)
			data0.add((long) (rnd.nextLong()%100));
		List<Comparable> data1 = new ArrayList(data0);
		//System.out.println(data0);
		Long[] data2 = data1.toArray(new Long[]{});
		
		sort.insertionSort(data1);
		Arrays.sort(data2);
		//System.out.println(Arrays.asList(data1));
		//System.out.println(Arrays.asList(data2));
		for (int i=0; i<data1.size(); i++)
			assertTrue(data0+" \nSort to:"+Arrays.asList(data1), data1.get(i).compareTo(data2[i])==0);
	}

	@Test
	public void testQuickSort() {
		
		//Integer[] data = new Integer[]{2,30,5,89,7,4,3};
		List<Comparable> data1 = new ArrayList();
		Random rnd = new Random();
		for (int i=0; i<1000; i++)
			data1.add((long) (rnd.nextLong()%100));
		//System.out.println(data0);
		Long[] data2 = data1.toArray(new Long[]{});
		List<Comparable> data3 = new ArrayList();
		data3.addAll(data1);
		
		List<Comparable> result1 = QuickSort.quickSort(data1);
		QuickSort.quickSortInPlace(data3, 0, data3.size()-1);
		Arrays.sort(data2);
		//System.out.println(result1);
		//System.out.println(Arrays.asList(data2));
		for (int i=0; i<result1.size(); i++) {
			assertTrue(data1+"; \nQuickSort to:"+Arrays.asList(result1), result1.get(i).compareTo(data2[i])==0);
			assertTrue(data1+"; \nQuickSort(in place) to:"+Arrays.asList(data3), data3.get(i).compareTo(data2[i])==0);
		}
	}
}
