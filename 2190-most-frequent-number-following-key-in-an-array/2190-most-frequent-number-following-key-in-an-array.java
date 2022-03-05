class Solution {
    public int mostFrequent(int[] nums, int key) {
        Map<Integer, Integer> mp = new HashMap<>();
        
        for (int i=0; i<nums.length-1; i++) {
            if (nums[i] == key) {
                mp.put(nums[i+1], mp.getOrDefault(nums[i+1], 0) + 1);   
            }
        }
        
        int ans = Integer.MIN_VALUE;
        int maxFreq = Integer.MIN_VALUE;
        
        for (int val : mp.keySet()) {
            if (maxFreq < mp.get(val)) {
                maxFreq = mp.get(val);
                ans = val;
            }
        }
        
        return ans;
    }
}