class Solution {
    public int minimumOperations(int[] nums) {
        int n = nums.length;
        // System.out.println(n);
        if (n==1)   return 0;
        
        Map<Integer, Integer> evens = new TreeMap<>();
        Map<Integer, Integer> odds = new TreeMap<>();
        
        for (int i=0; i<n; i++) {
            if (i%2 == 0) {
                evens.put(nums[i], evens.getOrDefault(nums[i], 0)+1);
            } else {
                odds.put(nums[i], odds.getOrDefault(nums[i], 0)+1);    
            }
        }
        
        System.out.println(odds);
        System.out.println(evens);
        
        int maxEvenKey = Integer.MIN_VALUE;
        int maxEvenFreq = Integer.MIN_VALUE;
        int secondMaxEvenKey = Integer.MIN_VALUE;
        int secondMaxEvenFreq = Integer.MIN_VALUE;
        
        int maxOddKey = Integer.MIN_VALUE;
        int maxOddFreq = Integer.MIN_VALUE;
        int secondMaxOddKey = Integer.MIN_VALUE;
        int secondMaxOddFreq = Integer.MIN_VALUE;
        
        for (int key : evens.keySet()) {
            if (evens.get(key) >= maxEvenFreq) {
                secondMaxEvenKey = maxEvenKey;
                maxEvenKey = key;
                secondMaxEvenFreq = maxEvenFreq;
                maxEvenFreq = evens.get(key);
            } else if (evens.get(key) > secondMaxEvenFreq) {
                secondMaxEvenKey = key;
                secondMaxEvenFreq = maxEvenFreq;
            }
        }
        
        for (int key : odds.keySet()) {
            if (odds.get(key) >= maxOddFreq) {
                secondMaxOddKey = maxOddKey;
                maxOddKey = key;
                secondMaxOddFreq = maxOddFreq;
                maxOddFreq = odds.get(key);
            } else if (odds.get(key) > secondMaxOddFreq) {
                secondMaxOddKey = key;
                secondMaxOddFreq = maxOddFreq;
            }
        }
        
        System.out.printf("%d %d %d %d\n", maxEvenKey, maxEvenFreq, maxOddKey, maxOddFreq);
        
        if (maxEvenKey == maxOddKey) {
            System.out.println(secondMaxOddKey);
            return n - Math.max(maxEvenFreq + odds.getOrDefault(secondMaxOddKey, 0),
                                maxOddFreq + evens.getOrDefault(secondMaxEvenKey, 0));
        }
        
        return n - maxEvenFreq - maxOddFreq;
    }
}