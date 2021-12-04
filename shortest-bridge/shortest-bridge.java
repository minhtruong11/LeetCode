class Solution {
    public int shortestBridge(int[][] grid) {
        
        int m = grid.length, n = grid[0].length;
        Deque<int[]> q = new ArrayDeque<>(); 
            
        for(int i=0; i<m; i++) {
            boolean flag = false;
            for(int j=0; j<n; j++) {
                if(grid[i][j] == 1) {
                    dfs(i, j, grid, m, n, q);
                    flag=true;
                    break;
                }
            }
            if(flag) {
                break;
            }
        }
        
        int dist=-1;
        int dirs[][]={{1,0},{-1,0},{0,1},{0,-1}};
        
        while(!q.isEmpty()) {
            int sz = q.size();
            dist++;
            while(sz-->0) {
                int[] pos = q.pollFirst();
                for(int[] dir : dirs) {
                    int[] newPos = new int[] {pos[0] + dir[0], pos[1] + dir[1]};
                    if(newPos[0]>=0 && newPos[0]<m &&
                      newPos[1] >= 0 && newPos[1]<n ) {
                        if(grid[newPos[0]][newPos[1]] == 1) {
                            return dist;
                        } else if(grid[newPos[0]][newPos[1]] == 0) {
                            grid[newPos[0]][newPos[1]] = 2;
                            q.offerLast(newPos);
                        }
                    }
                }
            }
        }
        
        return -1;
    }
    
    void dfs(int i, int j, int[][] grid, int m, int n, Deque<int[]> q) {
        if(i<0 || j<0 || i>=m || j>=n || grid[i][j] != 1)  
            return;
        grid[i][j] = 2;
        q.offerLast(new int[] {i, j});
        dfs(i+1, j, grid, m, n, q);
        dfs(i, j+1, grid, m, n, q);
        dfs(i, j-1, grid, m, n, q);
        dfs(i-1, j, grid, m, n, q);
    }
}