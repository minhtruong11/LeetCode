class Solution {
    
    public int lis(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = 1;    

        int maxLength = 1;
        for (int i=1; i<nums.length; i++) { 
          dp[i] = 1; 
          for (int j=0; j<i; j++)   
            if (nums[i] > nums[j] && dp[i] <= dp[j] ) {
              dp[i] = dp[j]+1;  
              maxLength = Math.max(maxLength, dp[i]);
            }
        } 
        return maxLength;
    }
    
    public boolean canBeIncreasing(int[] nums) {
        
        int n = nums.length;
        
        if(n==2)    return true;
        
        int l = lis(nums);
        
        if(l >= n-1) {
            return true;
        }
        
        return false;
        
    }
}