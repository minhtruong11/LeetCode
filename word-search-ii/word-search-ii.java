class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        
        for(String word : words) {
            if(isPresent(board, word)) {
                res.add(word);
            }
        }
        
        return res;
    }
    
    boolean isPresent(char[][] board, String word) {
        int m=board.length;
        int n=board[0].length;
        
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(word.charAt(0) == board[i][j]) {
                    if(dfs(i, j, board, m, n, word, 0)) {
                        return true;
                    }
                }
            }
        }
        
        return false;
    }
    
    boolean dfs(int i, int j, char[][] board, int m, int n, String word, int idx) {
        if(idx == word.length())  return true;
        if(i<0 || j<0 || i>=m || j>=n) return false;
        if(board[i][j] != word.charAt(idx)) {
            return false;
        }
        board[i][j] = '*';
        
        boolean res = dfs(i+1, j, board, m, n, word, idx+1) ||
        dfs(i-1, j, board, m, n, word, idx+1) ||
        dfs(i, j-1, board, m, n, word, idx+1) ||
        dfs(i, j+1, board, m, n, word, idx+1);
        
        board[i][j] = word.charAt(idx);
        return res;
    }
}