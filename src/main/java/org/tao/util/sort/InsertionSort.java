package org.tao.util.sort;

import java.util.List;

public class InsertionSort {
	public static void insertionSort(List<Comparable> data) {
		for (int i=1; i<data.size(); ++i) {
			for (int j=i; j>0; --j) {
				if (data.get(j-1).compareTo(data.get(j))>0) {
					Comparable tmp = data.get(j-1);
					data.set(j-1, data.get(j));
					data.set(j, tmp);
				}
				else
					break;
			}
		}
	}
}
