class Solution {
    int n;
    int m;
    
    public int dfs(int[][] grid, int x, int y, int[][] memo) {
        if(x>=n || y>=m)  return 0;
        if(memo[x][y] != -1)    return memo[x][y];
        if(x == n-1 && y == m-1) {
            return 1;
        }
        if(grid[x][y] == 1) {
            memo[x][y] = 0;
            return 0;
        }
        grid[x][y] = 1;
        int down = dfs(grid, x+1, y, memo);
        int right = dfs(grid, x, y+1, memo);
        memo[x][y] = down+right;
        grid[x][y] = 0;
        return memo[x][y];
    }
    
    public int uniquePathsWithObstacles(int[][] grid) {
        this.n = grid.length;
        this.m = grid[0].length;
        int[][] memo = new int[n][m];
        Arrays.stream(memo).forEach(row -> {
           Arrays.fill(row, -1); 
        });
        if(grid[0][0] == 1 || grid[n-1][m-1] == 1) return 0;
        return dfs(grid, 0, 0, memo);
    }
}