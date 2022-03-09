class Solution {
    
    Map<Integer, Boolean> memo = new HashMap<>();
    
    public boolean dp(int[] nums, int n, int idx, boolean[] visited) {
        if (idx>=n-1) {
            return true;
        }
        
        if (visited[idx])    return false;
        visited[idx] = true;
        
        if (nums[idx] == 0) return false;
        
        if (memo.containsKey(idx)) {
            return memo.get(idx);
        }
        
        for (int i=nums[idx]; i>=1; i--) {
            if (dp(nums, n, idx+i, visited)) {
                memo.put(idx+i, true);
                return true;
            }
        }
        
        memo.put(idx, false);
        return false;
    }
    
    public boolean canJump(int[] nums) {
        boolean[] visited = new boolean[nums.length];
        return dp(nums, nums.length, 0, visited);
    }
}