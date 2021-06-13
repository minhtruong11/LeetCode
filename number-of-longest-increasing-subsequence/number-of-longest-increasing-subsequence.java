class Solution {
    public int findNumberOfLIS(int[] arr) {
        List<Integer> nums = new ArrayList<>();
        Arrays.stream(arr).forEach(nums::add);
        int[] dp = new int[nums.size()];
        int best = 0;
        int[] count = new int[arr.length];
        int maxCount = 0;
        
        for (int i = 0; i < nums.size(); i++) {
            dp[i] = count[i] = 1;
            
            for (int j = 0; j < i; j++) {
                if (nums.get(i) > nums.get(j)) {
                    if(dp[i] < dp[j]+1) {
                        dp[i] = dp[j] + 1;
                        count[i] = count[j];
                    } else if(dp[i] == dp[j]+1) {
                        count[i] += count[j];
                    }
                }
            }
            if(dp[i]>best) {
                best = dp[i];
                maxCount = count[i];
            } else if(best == dp[i]) 
                maxCount += count[i];
        }
        
        return maxCount;
    }
}