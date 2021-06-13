class Solution {
    
    public int minDistance(String word1, String word2) {
        int l1 = word1.length();
        int l2 = word2.length();
        int[][] memo = new int[l1+1][l2+1];
        
        Arrays.stream(memo).forEach(row -> {
            Arrays.fill(row, -1);
        });
        
        return l1+l2 - 2*lcs(word1, l1-1, word2, l2-1, memo);
        
    }
    
    int lcs(String w1, int i, String w2, int j, int[][] memo) {
        if(i<0 || j<0) {
            return 0;
        }
        
        if(memo[i][j] != -1)    return memo[i][j];
        
        if(w1.charAt(i) == w2.charAt(j)) {
             memo[i][j] = lcs(w1, i-1, w2, j-1, memo) + 1;
            return memo[i][j];
        }
        
        int a = lcs(w1, i-1, w2, j, memo);
        int b = lcs(w1, i, w2, j-1, memo);
        
        memo[i][j] = Math.max(a, b);
        return memo[i][j];
    }
    
}