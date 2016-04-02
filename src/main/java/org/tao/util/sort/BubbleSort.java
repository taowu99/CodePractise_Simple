package org.tao.util.sort;

public class BubbleSort {
	public static void sort(Comparable[] data) {
		int fxIdx = data.length;
		while (fxIdx>=1) {
			boolean swapped = false;
			for (int i=0; i<fxIdx-1; ++i) { //Caution: the upperbound is one pos before swapped space
				if (data[i].compareTo(data[i+1]) > 0) {
					Comparable t = data[i];
					data[i] = data[i+1];
					data[i+1] = t;
					swapped=true;
				}
			}
			
			if (!swapped)	//if no swap, it mean the array is sorted
				break;
			
			fxIdx--;
		}
	}

}
