class Solution {
    public int maxSubArray(int[] nums) {
        
        boolean positivePresent = false;
        int maxNegative = Integer.MIN_VALUE;
        
        for (int num : nums) {
            if (num > 0) {
                positivePresent = true;
                break;
            }
            maxNegative = Math.max(maxNegative, num);
        }
        
        if (!positivePresent)   return maxNegative;
        
        int maxSum = Integer.MIN_VALUE;
        int windowSum = 0;
        
        for (int end=0; end<nums.length; end++) {
            windowSum += nums[end];
            
            if (windowSum < 0) {
                windowSum = 0;
            } 
            
            maxSum = Math.max(maxSum, windowSum);
        }
        
        return maxSum;
    }
}