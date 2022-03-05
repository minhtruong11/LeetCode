class Solution {
    
    HashMap<Integer, Integer> memo = new HashMap<>();
    
    public int climbStairs(int n) {
        if (n == 0 || n == 1)   return 1;
        if (n == 2) return 2;
        
        if (memo.containsKey(n)) return memo.get(n);
        
        int val = climbStairs(n-1) + climbStairs(n-2);
        memo.put(n, val);
        
        return val;
    }
}