class Solution {
    int[] dr = new int[]{-1, 0, 1, 0};
    int[] dc = new int[]{0, -1, 0, 1};
    int N;
    
    public int largestIsland(int[][] grid) {
        int index = 2;
        int m = grid.length;
        int n = grid[0].length;
        this.N = m;
        
        int[] area = new int[m*n+2];
        
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(grid[i][j] == 1) {
                    area[index] = dfs(i, j, grid, index++);
                }
            }
        }
        
        int ans = Arrays.stream(area).max().orElse(0);
        
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(grid[i][j] == 0) {
                    Set<Integer> seen = new HashSet<>();
                    for(Integer move: neighbors(i, j)) {
                        if(grid[move/m][move % n] > 1) {
                            seen.add(grid[move/m][move % n]);
                        }
                    }
                    int bns = 1;
                    for(int k: seen)    bns += area[k];
                    ans = Math.max(ans, bns);
                }
            }
        }
        
        return ans;
    }
    
    public int dfs(int r, int c, int[][] grid, int index) {
        int ans = 1;
        grid[r][c] = index;
        for (Integer move: neighbors(r, c)) {
            if (grid[move / N][move % N] == 1) {
                grid[move / N][move % N] = index;
                ans += dfs(move / N, move % N, grid, index);
            }
        }

        return ans;
    }
    
    public List<Integer> neighbors(int r, int c) {
        List<Integer> ans = new ArrayList();
        for (int k = 0; k < 4; ++k) {
            int nr = r + dr[k];
            int nc = c + dc[k];
            if (0 <= nr && nr < N && 0 <= nc && nc < N)
                ans.add(nr * N + nc);
        }

        return ans;
    }
}