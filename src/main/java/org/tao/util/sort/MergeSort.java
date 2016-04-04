package org.tao.util.sort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MergeSort {
	public static List<Comparable> mergeSort(List<Comparable> data) {
		List<Comparable> lft = new ArrayList();
		List<Comparable> rgt = new ArrayList();
		for (int i=0; i<data.size(); ++i) {
			if (i<data.size()/2) {
				lft.add(data.get(i));
			}
			else {
				rgt.add(data.get(i));
			}
		}
		if (lft.size()>1)
			lft = mergeSort(lft);
		if (rgt.size()>1)
			rgt = mergeSort(rgt);
		return merge(lft,rgt);
	}

	private static List<Comparable> merge(List<Comparable> lft, List<Comparable> rgt) {
		List<Comparable> result = new ArrayList();
		int idxLft=0, idxRgt=0;
		while (idxLft<lft.size() && idxRgt<rgt.size())
			if (lft.get(idxLft).compareTo(rgt.get(idxRgt))<0) 
				result.add(lft.get(idxLft++));
			else 
				result.add(rgt.get(idxRgt++));
		
		while (idxLft<lft.size())
			result.add(lft.get(idxLft++));
		while (idxRgt<rgt.size())
			result.add(rgt.get(idxRgt++));
		
		return result;
	}
	
	public static void mergeSortInPlace(LinkedList<Comparable> data) {
		mergeSortInPlace(data, 0, data.size()-1);
	}
	public static void mergeSortInPlace(LinkedList<Comparable> data, int from, int to) {
		if (from<0 || to >= data.size() || from>=to)
			return;
		
		final int mid = (to+from)/2;
		mergeSortInPlace(data, from, mid);
		mergeSortInPlace(data, mid+1, to);
		mergeInPlace(data,from,mid,to);
	}

	private static void mergeInPlace(LinkedList<Comparable> data, int from, int mid, int to) {
		int idxLeft = from;
		int idxRght = mid+1;
		while (idxLeft<=mid && idxRght<=to) {
			if (data.get(idxLeft).compareTo(data.get(idxRght))>0) {
				Comparable tmp = data.remove(idxRght++);
				data.add(idxLeft++, tmp);
				mid++;
			}
			else
				idxLeft++;
		}
	}
}
