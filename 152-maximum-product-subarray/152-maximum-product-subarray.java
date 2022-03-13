class Solution {
    public int maxProduct(int[] nums) {
        int left = 1;
        int right = 1;
        int maxP = Integer.MIN_VALUE;
        
        for (int i=0; i<nums.length; i++) {
            left = (left == 0 ? 1 : left) * nums[i];
            right = (right == 0 ? 1 : right) * nums[nums.length - i - 1];
            maxP = Math.max(maxP, Math.max(left, right));
        }
        
        return maxP;
    }
}