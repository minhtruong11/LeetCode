class Solution {
    public int closedIsland(int[][] grid) {
        int count=0; 
        int n=grid.length;
        int m=grid[0].length;
        
        boolean[][] visited = new boolean[n][m]; 
        
        for(int i=1; i<n-1; i++) {
            for(int j=1; j<m-1; j++) {
                if(grid[i][j] == 0 && !visited[i][j]) 
                    if(dfs(grid, i, j, visited)) {
                        count++;
                        //System.out.printf("%d %d\n", i, j);
                    }
            }
        }
        return count;
    }
    
    public static boolean dfs(int[][] grid, int i, int j, boolean[][] visited) {
        int[] dirX = {1, 0, -1, 0};
        int[] dirY = {0, -1, 0, 1};
        
        int n=grid.length;
        int m=grid[0].length;
        
        visited[i][j] = true;
           
        //if(grid[i][j] == 1) return true;
        boolean flag=true;
        
        for(int k=0; k<4; k++) {
            int[] newPos = new int[]{i+dirX[k], j+dirY[k]};
            
            if(newPos[0] >= 0 && newPos[0] <n &&
               newPos[1] >= 0 && newPos[1]<m && !visited[newPos[0]][newPos[1]]) {
                
                if(grid[newPos[0]][newPos[1]] == 0) {
                    if(!dfs(grid, newPos[0], newPos[1], visited))    flag=false;
                    if(newPos[0] == 0 || newPos[0] == n-1 ||
                      newPos[1] == 0 || newPos[1] == m-1) {
                        flag=false;
                    }
                }
            } 
        }
        
        return flag;
    }
    
}