class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] memo = new int[text1.length()][text2.length()];
        Arrays.stream(memo).forEach(row -> {
            Arrays.fill(row, -1);
        });
        return lcs(text1, text1.length()-1, text2, text2.length()-1, memo);   
    }
    
    private int lcs(String s1, int i, String s2, int j, int [][] memo) {

        if(i<0 || j<0)  return 0;
        
        if(memo[i][j] != -1)    return memo[i][j];

        if(s1.charAt(i) == s2.charAt(j)) {
            memo[i][j] = lcs(s1, i-1, s2, j-1, memo) + 1;
            return memo[i][j];
        }

        int a = lcs(s1, i-1, s2, j, memo);
        int b = lcs(s1, i, s2, j-1, memo);

        memo[i][j] = Math.max(a, b);
        return memo[i][j];
    }
}