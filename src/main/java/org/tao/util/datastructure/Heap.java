package org.tao.util.datastructure;

import java.util.ArrayList;

public class Heap {
	private ArrayList<Comparable> space = new ArrayList();

	public int size() {
		return space.size();
	}

	public Comparable peek() {
		return space.isEmpty() ? null : space.get(0);
	}

	public boolean isEmpty() {
		return space.isEmpty();
	}

	public void insert(Comparable elm) {
		space.add(elm);
		shiftUp(space.size() - 1);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void shiftUp(int idx) {
		Comparable me = space.get(idx);
		int idxP = getParent(idx);
		if (idxP < 0)
			return;

		Comparable parent = space.get(idxP);
		if (parent.compareTo(me) > 0) {
			space.set(idxP, me);
			space.set(idx, parent);
			shiftUp(idxP);
		}
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void shiftDown(int idx) {
		Comparable me = space.get(idx);
		int idxChildLeft = indexLeftChild(idx);
		int idxChildRight = indexRightChild(idx);

		if (idxChildLeft >= space.size())
			return;
//System.out.println("size:"+space.size()+"; idxChildRight: "+idxChildRight);
		Comparable left = space.get(idxChildLeft);
		Comparable right = idxChildRight >= space.size()?null:space.get(idxChildRight);
        
        int idxSwitch = right==null || left.compareTo(right)<0? idxChildLeft:idxChildRight;
        if (me.compareTo(space.get(idxSwitch))>0) {
            Comparable tmp = space.get(idx);
            space.set(idx, space.get(idxSwitch));
            space.set(idxSwitch, tmp);
            //System.out.println("shift "+idx+" => "+space);
            shiftDown(idxSwitch);
        }
	}

	public Comparable replaceRoot(Comparable newRoot) {
		Comparable root = space.get(0);
		space.set(0, newRoot);
		shiftDown(0);
		return root;
	}

	public int getParent(int idx) {
		if (idx == 0)
			return -1;
		return (idx + 1) / 2 - 1;
	}

	public int indexLeftChild(int idx) {
		if (idx >= space.size())
			return -1;
		return 2 * (idx + 1) - 1;
	}

	public int indexRightChild(int idx) {
		if (idx >= space.size())
			return -1;
		return 2 * (idx + 1);
	}

	public Comparable extract() {
		if (space.isEmpty())
			return null;

		Comparable root = space.get(0);
		if (space.size() == 1) {
			space.remove(0);
			return root;
		}

		Comparable tmp = space.get(space.size() - 1);
		space.remove(space.size() - 1);
		replaceRoot(tmp);
		return root;
	}

    private void delete(Comparable elm) {
        int idx = find(0, elm);
        if (idx == -1)
            return;
        if (idx == space.size()-1) {
            space.remove(idx);
        }
        else {                
            Comparable tmp = space.get(space.size()-1);
            space.set(idx, tmp);
            space.remove(space.size()-1);
            shiftDown(idx);
        }
    }
    
    private int find(int idxRoot, Comparable elm) {
        if (idxRoot>space.size()-1)
            return -1;
        if (space.get(idxRoot).compareTo(elm) == 0)
            return idxRoot;
        if (space.get(idxRoot).compareTo(elm)>0)
            return -1;
        return Math.max(find(indexLeftChild(idxRoot), elm), find(indexRightChild(idxRoot), elm));
    }
}
