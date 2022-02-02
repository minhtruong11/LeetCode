class Solution {
    public int maxDepth(String s) {
        int open = 0, close = 0;
        int maxDiff = Integer.MIN_VALUE;
        
        
        for (char c : s.toCharArray()) {
            
            maxDiff = Math.max(maxDiff, open - close);
            
            switch (c) {
                case '(':
                    open++;
                    break;
                case ')':
                    close++;
                    break;
            }
        }
        
        return maxDiff;
    }
}