class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int minSum = Integer.MAX_VALUE;
        int maxSum = Integer.MIN_VALUE;
        int total = 0;
        int currMin = 0;
        int currMax = 0;
        
        for (int num : nums) {
            currMin = Math.min(currMin + num, num);
            currMax = Math.max(currMax + num, num);
            total += num;
            minSum = Math.min(currMin, minSum);
            maxSum = Math.max(currMax, maxSum);
        }
        
        return maxSum < 0 ? maxSum : Math.max(maxSum, total - minSum);
        
    }
}