class Solution {
    
    Map<Integer, Integer> memo = new HashMap<>();
    
    public int tribonacci(int n) {
        if (n == 0 || n == 1)   return n;
        if (n == 2) return 1;
        
        if (memo.containsKey(n))    return memo.get(n);
        
        int val = tribonacci(n-1) +
            tribonacci(n-2) + 
            tribonacci(n-3);
        
        memo.put(n, val);
        
        return val;
    }
}