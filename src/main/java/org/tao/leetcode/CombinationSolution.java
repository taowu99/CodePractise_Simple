package org.tao.leetcode;

import java.util.*;

public class CombinationSolution {
	public List<List<Integer>> combine(int n, int k) {
        if (k>n)
        	return null;
        else if (k==n) {
        	List<List<Integer>> results = new ArrayList();
        	List<Integer> result = new ArrayList();
        	for (int i=1; i<=n; ++i)
        		result.add(i);
        	results.add(result);
        	return results;        		
        }
        else if (k==1) {
        	List<List<Integer>> results = new ArrayList();
        	
        	for (int i=1; i<=n; ++i) {
        		List<Integer> result = new ArrayList();
        		result.add(i);
        		results.add(result);
        	}
        	
        	return results;
        }
        else {
        	List<List<Integer>> resultsWithN = combine(n-1,k-1);
        	for (List<Integer> res : resultsWithN)
        		res.add(n);
        	List<List<Integer>> resultsWithoutN = combine(n-1,k);
        	
        	if (resultsWithoutN==null)
        		return resultsWithN;
        	
        	resultsWithoutN.addAll(resultsWithN);
        	return resultsWithoutN;
        }
    }

	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> result = new ArrayList<>();
		combinationSum(candidates,target,result, new ArrayList<Integer>());
		return result;
	}

	public void combinationSum(int[] candidates, int target, List<List<Integer>> result, List<Integer> prvComb) {
		if (target==0)
			result.add(prvComb);
		else {
			for (Integer cnd : candidates) {
				if (prvComb.size()>0 && cnd<prvComb.get(prvComb.size()-1) || target<cnd)
					continue;
				List<Integer> newPrvComb = new ArrayList<>(prvComb);
				newPrvComb.add(cnd);
				combinationSum(candidates, target-cnd, result, newPrvComb);
			}
		}
	}

	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		List<List<Integer>> result = new ArrayList<>();
		//Arrays.sort(candidates);
		combinationSum2(candidates, target, 0, result, new ArrayList<Integer>());
		return result;
	}

	public void combinationSum2(int[] candidates, int target, int cndIdx, List<List<Integer>> result, List<Integer> prvComb) {
		if (target==0)
			result.add(prvComb);
		else {
			for (int idx=cndIdx; idx<candidates.length; ++idx) {
				int cnd = candidates[idx];
				if (target<cnd || candidates[idx]==candidates[idx-1])
					continue;
				List<Integer> newPrvComb = new ArrayList<>(prvComb);
				newPrvComb.add(cnd);
				combinationSum2(candidates, target-cnd, cndIdx+1, result, newPrvComb);
			}
		}
	}

	public List<List<Integer>> combinationSum3(int k, int n) {
		List<List<Integer>> result = new ArrayList<>();
		combinationSum3(k,n,result, new ArrayList<Integer>(), 0);
		return result;
	}

	public void combinationSum3(int k, int n, List<List<Integer>> result, List<Integer> prvComb, int start) {
		if (k==0) {
			if (n == 0)
				result.add(new ArrayList(prvComb));
		} else {
			for (int cnd=start; cnd<9; ++cnd) {
				if (prvComb.size()>0 && cnd<=prvComb.get(prvComb.size()-1))
					continue;
				prvComb.add(cnd);
				combinationSum3(k-1,n-cnd, result, prvComb, cnd+1);
				prvComb.remove(prvComb.size()-1);
			}
		}
	}
}
