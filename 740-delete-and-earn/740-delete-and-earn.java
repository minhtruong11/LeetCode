class Solution {
    
    Map<Integer, Integer> memo = new HashMap<>();
    
    public int dp(int[] freqArr, int n, int i) {
        if (i >= n) {
            return 0;
        }
        
        if (memo.containsKey(i))    return memo.get(i);
        
        int val = Math.max(freqArr[i] + dp(freqArr, n, i+2),
                dp(freqArr, n, i+1));
        
        memo.put(i, val);
        
        return val;
    }
    
    public int deleteAndEarn(int[] nums) {
        int max = Arrays.stream(nums).max().getAsInt();
        int[] freqArr = new int[max+1];
        
        for (int num : nums) {
            freqArr[num] += num;
        }
        
        return dp(freqArr, freqArr.length, 0);
    }
}