class Solution {
    
    public int _rob(int[] nums, int n, int i, Map<Integer, Integer> memo) {
        if (i >= n) {
            return 0;
        }
        
        if (memo.containsKey(i))    return memo.get(i);
        
        memo.put(i, Math.max(_rob(nums, n, i+1, memo),
                             _rob(nums, n, i+2, memo) + nums[i]));
        
        return memo.get(i);
    }
    
    public int rob(int[] nums) {
        
        if (nums.length == 1)   return nums[0];
        
        return Math.max(_rob(nums, nums.length-1, 0, new HashMap<>()),
                        _rob(nums, nums.length, 1, new HashMap<>()));
    }
}