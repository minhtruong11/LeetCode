class Solution {
    
    Map<Integer, Integer> memo = new HashMap<>();
    
    public int _rob(int[] nums, int n, int i) {
        if (i >= n) {
            return 0;
        }
        
        if (memo.containsKey(i))    return memo.get(i);
        
        memo.put(i, Math.max(_rob(nums, n, i+1),
                             _rob(nums, n, i+2) + nums[i]));
        
        return memo.get(i);
    }
    
    public int rob(int[] nums) {
        return _rob(nums, nums.length, 0);
    }
}