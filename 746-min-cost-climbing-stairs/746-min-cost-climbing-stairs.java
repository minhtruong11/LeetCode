class Solution {
    
    Map<Integer, Integer> memo = new HashMap<>();
    
    int _cost(int[] cost, int i) {
        if (i >= cost.length) return 0;
        
        if (memo.containsKey(i))    return memo.get(i);
        
        int val = cost[i] + Math.min( _cost(cost, i+1), 
                                   _cost(cost, i+2));
        
        memo.put(i, val);
        
        return val;
    }
    
    public int minCostClimbingStairs(int[] cost) {
        return Math.min(_cost(cost, 0),
                        _cost(cost, 1));    
    }
}