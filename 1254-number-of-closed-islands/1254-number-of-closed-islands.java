class Solution {
    
    public void dfs(int[][] grid, int m, int n, int i, int j) {
        if (i<0 || j<0 || i>=m || j>=n || grid[i][j] == 1)  return;
        
        grid[i][j] = 1;
        
        dfs(grid, m, n, i+1, j);
        dfs(grid, m, n, i, j+1);
        dfs(grid, m, n, i-1, j);
        dfs(grid, m, n, i, j-1);
    }
    
    public int closedIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (i == 0 || j == 0 || i== m-1 || j == n-1) {
                    if (grid[i][j] == 0) {
                        dfs(grid, m, n, i, j);
                    }
                }
            }
        }
        
        int count=0;
        
        for (int i=1; i<m-1; i++) {
            for (int j=1; j<n-1; j++) {
                if (grid[i][j] == 0) {
                    count++;
                    dfs(grid, m, n, i, j);
                }
            }
        }
        
        return count;
    }
}