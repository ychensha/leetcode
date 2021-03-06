package leetcode;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class ThreeSumClosest {
    public int threeSumClosest(int[] num, int target) {
    	  	Arrays.sort(num);
    	  	int result = 0;
    	  	int minGap = Integer.MAX_VALUE;
    	  	int currentGap = 0;
    	  	int currentTwoSum = 0;
    	  	for(int i = 0; i < num.length; ++i) {
    	  		int twoSumTarget = target - num[i];
    	  		int left = i + 1;
    	  		int right = num.length - 1;
    	  		while(left < right) {
    	  			currentTwoSum = num[left] + num[right];
    	  			currentGap = Math.abs(currentTwoSum - twoSumTarget);
    	  			if(currentGap < minGap) {
    	  				result = currentTwoSum + num[i];
    	  				minGap = currentGap;
    	  			}
    	  			if(currentTwoSum < twoSumTarget) {
    	  				left++;
    	  			} else {
    	  				right--;
    	  			}
    	  		}
    	  	}
    	  	return result;
    }
    public class Solution {
        public int threeSumClosest(int[] nums, int target) {
            long res = Integer.MAX_VALUE;
            Arrays.sort(nums);
            for(int i = 0; i < nums.length - 2; i++) {
            		for(int j = i + 1, k = nums.length - 1; j < k;) {
            			int sum = nums[i] +  nums[j] + nums[k];
            			if(Math.abs(target - sum) < Math.abs(target - res))
            				res = sum;
            			if(sum < target)
            				j++;
            			else if(sum > target)
            				k--;
            			else {
            				j++;k--;
            			}
            		}
            }
            return (int)res;
        }
    }
    
    private Solution sln = new Solution();
	@Test
	public void test() {
		assertEquals(0, sln.threeSumClosest(new int[]{0,0,0}, 1) );
	}
	
}
