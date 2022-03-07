class Solution {
    
    boolean isSubIsland;
    
    public void dfs(int[][] grid1, int[][] grid2, int m, int n, int i, int j) {
        if (i<0 || j<0 || i>=m || j>=n || grid2[i][j] == 0)     return;
        if (grid1[i][j] == 0) {
            isSubIsland = false;
        }
        grid2[i][j] = 0;
        
        dfs(grid1, grid2, m, n, i+1, j);
        dfs(grid1, grid2, m, n, i-1, j);
        dfs(grid1, grid2, m, n, i, j+1);
        dfs(grid1, grid2, m, n, i, j-1);
    }
    
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int m = grid1.length;
        int n = grid1[0].length;
        int count=0;
        
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (grid2[i][j] == 1) {
                    isSubIsland = true;
                    dfs(grid1, grid2, m, n, i, j);
                    if (isSubIsland) {
                        count++;
                    }
                }
            }
        }
        
        return count;
    }
}