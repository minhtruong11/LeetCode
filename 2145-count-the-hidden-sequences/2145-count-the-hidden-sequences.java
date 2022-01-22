class Solution {
    public int numberOfArrays(int[] differences, int lower, int upper) {
        int n = differences.length;
        int[] hidden = new int[n+1];   
        
        hidden[0] = lower;
        int minValue = lower;
        int maxValue = lower;
        
        for (int i=1; i<n+1; i++) {
            hidden[i] = hidden[i-1] + differences[i-1];
            minValue = Math.min(minValue, hidden[i]);
            maxValue = Math.max(maxValue, hidden[i]);
        }
        
        if (minValue >= lower && maxValue <= upper) {
            return upper - maxValue + 1;
        } else if (maxValue >= upper) {
            return 0;
        } else if (minValue <= lower && maxValue < upper) {
            if (maxValue + (lower - minValue) > upper) {
                return 0;
            } else {
                return upper - (maxValue + (lower - minValue)) + 1;
            }
        }
        
        return 0;
    }
}