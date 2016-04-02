package org.tao.util.sort;

import java.util.ArrayList;
import java.util.List;

public class QuickSort {
	public List<Comparable> quickSort(List<Comparable> data) {
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
}
