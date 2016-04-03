package org.tao.util.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QuickSort {
	public static List<Comparable> quickSort(List<Comparable> data) {
		//System.out.println(data);
		if (data==null || data.size()<2)
			return data;
		List<Comparable> result = new ArrayList();
		Comparable pivot = data.get(0);
		List<Comparable> bf = new ArrayList();
		List<Comparable> eq = new ArrayList();
		List<Comparable> af = new ArrayList();
		for (Comparable dt : data) {
			int cmp = dt.compareTo(pivot);
			if (cmp<0)
				bf.add(dt);
			else if (cmp>0)
				af.add(dt);
			else
				eq.add(dt);
		}
		//System.out.println(data+"=>"+bf+" "+pivot+" "+af);
		result.addAll(quickSort(bf));
		result.addAll(eq);
		result.addAll(quickSort(af));
		//System.out.println(data+" =) "+bf);
		return result;
	}
	
	public static void quickSortInPlace(List<Comparable> data, int from, int to) {
		//System.out.println("sorting "+from+" to "+to);
		if (data==null || data.size()<2 || (to-from)<1)
			return;
		if (from<0 || to <0 || from>data.size() || to>data.size()) {
			throw new IndexOutOfBoundsException(data+" from "+from+" to "+to);
		}
		
		Comparable pivot = data.get(to);
		int pos=from;
		for (int i=from; i<to; ++i ) {
			if (data.get(i).compareTo(pivot)<0) {
				if (i!=pos) {
					Comparable tmp = data.get(i);
					data.set(i,data.get(pos));
					data.set(pos, tmp);
					//System.out.println(data.get(i)+"<=>"+tmp);
				}
				pos++;
			}
			//System.out.println(Arrays.asList(data));
		}
		
		if (pos!=to) {
			Comparable tmp = data.get(to);
			data.set(to, data.get(pos));
			data.set(pos, tmp);
		}
		
		//System.out.println(Arrays.asList(data)+" ["+pos+"]"+pivot+" ("+from+","+to+")");
		quickSortInPlace(data,from, pos-1);
		quickSortInPlace(data,pos+1,to);
	}
}
