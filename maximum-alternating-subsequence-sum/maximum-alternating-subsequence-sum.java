class Solution {
    public long maxAlternatingSum(int[] nums) {
        
        long peak = 0;
        long valley = 0;
        int n = nums.length;
        long ans = Integer.MIN_VALUE;
        
        for(int i=0; i<n-1;) {
            while(i<n-1 && nums[i] <= nums[i+1]) {
                i++;
            }
            
            peak += nums[i];
            
            ans = Math.max(ans, peak-valley);
            
            while(i<n-1 && nums[i] >= nums[i+1]) {
                i++;
            }
            
            valley += nums[i];
            
            ans = Math.max(ans, peak-valley);
        }
        
        return ans;
    }
}