package org.tao.util.sort;

import java.util.List;

public class SelectionSort {
	public static void selectionSort(List<Comparable> data) {
		for (int i=0; i<data.size(); ++i) {
			int idxSwap = i;
			for (int j=i; j<data.size(); ++j) {
				if (data.get(idxSwap).compareTo(data.get(j))>0) 
					idxSwap = j;
			}
			if (idxSwap!=i) {
				Comparable tmp = data.get(idxSwap);
				data.set(idxSwap, data.get(i));
				data.set(i, tmp);
			}
			//System.out.println(data);
		}
	}
}
