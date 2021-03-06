package leetcode;

import static org.junit.Assert.*;

import org.junit.Test;

import java.util.*;

public class Permutations {
    public List<List<Integer>> permute(int[] num) {
        List<List<Integer>> res = new ArrayList<>();
        permute(res, new LinkedList<>(), num, 0);
        return res;
    }
    
    private void permute(List<List<Integer>> res, List<Integer> item, int[] num, int begin) {
    		if(item.size() == num.length) {
    			res.add(new ArrayList<>(item));
    			return;
    		}
    		for(int i = begin; i < num.length; i++) {
    			swap(num, begin, i);
    			item.add(num[begin]);
    			permute(res, item, num, begin + 1);
    			item.remove(item.size() - 1);
    			swap(num, begin, i);
    		}
    }
    
    private void swap(int[] num, int left, int right) {
    		int tmp = num[left];
    		num[left] = num[right];
    		num[right] = tmp;
    }
    
    public class Solution {
    		private List<List<Integer>> res = new LinkedList<>();
    		private List<Integer> item = new LinkedList<>();
    		private int[] nums;
        public List<List<Integer>> permute(int[] nums) {
            this.nums = nums;
            permute(0);
            return res;
        }
        
        private void permute(int begin) {
        		if(begin == nums.length) {
        			res.add(new ArrayList<>(item));
        			return;
        		}
        		for(int i = begin; i < nums.length; i++) {
        			swap(begin, i);
        			item.add(nums[begin]);
        			permute(begin + 1);
        			item.remove(item.size() - 1);
        			swap(begin, i);
        		}
        }
        
        private void swap(int i1, int i2) {
        		int tmp = nums[i1];
        		nums[i1] = nums[i2];
        		nums[i2] = tmp;
        }
    }

    private Solution sln = new Solution();
    
	@Test
	public void test() {
		List<List<Integer>> result = permute(new int[] { 1 });
		assertEquals(1, result.size());
	}

	@Test
	public void test1() {
		System.out.println(sln.permute(new int[]{1,2,3}));
	}
}
