// class Solution {
    
//     int n;
//     int m;
//     int[] dirX = {-1, 1, 0, 0}; // UP, DOWN, LEFT, RIGHT
//     int[] dirY = {0, 0, -1, 1};
//     int[][] grid;
    
//     public int shortestDistance(int[][] maze, int[] start, int[] destination) {
//         n = maze.length;
//         m = maze[0].length;
        
//         int[][] dist = new int[n][m];
        
//         Arrays.stream(dist).forEach(row -> {
//             Arrays.fill(row, Integer.MAX_VALUE);
//         });
        
//         dist[start[0]][start[1]] = 0;
//         grid = maze;
        
//         dfs(start, dist);
        
//         return dist[destination[0]][destination[1]] == Integer.MAX_VALUE ? 
//                 -1 : 
//                 dist[destination[0]][destination[1]];
//     }
    
//     void dfs(int[] start, int[][] dist) {
        
//         for(int i=0; i<4; i++) {
//             int[] newPos = new int[]{start[0], start[1]};
//             int count=0;
            
//             while(newPos[0] >= 0 && newPos[0] < n && newPos[1] >= 0 && newPos[1] < m && 
//                   grid[newPos[0]][newPos[1]] == 0) {
//                 newPos[0] += dirX[i];
//                 newPos[1] += dirY[i];
//                 count++;
//             }
            
//             if(dist[start[0]][start[1]] + count < dist[newPos[0]-dirX[i]][newPos[1]-dirY[i]]) {
                
//                 dist[newPos[0]-dirX[i]][newPos[1]-dirY[i]] = dist[start[0]][start[1]] + count;
//                 newPos[0] -= dirX[i];
//                 newPos[1] -= dirY[i];
//                 dfs(newPos, dist);
            
//             }
//         }
//     }
// }

public class Solution {
    public int shortestDistance(int[][] maze, int[] start, int[] dest) {
        int[][] distance = new int[maze.length][maze[0].length];
        for (int[] row: distance)
            Arrays.fill(row, Integer.MAX_VALUE);
        distance[start[0]][start[1]] = 0;
        dfs(maze, start, distance);
        return distance[dest[0]][dest[1]] == Integer.MAX_VALUE ? -1 : distance[dest[0]][dest[1]];
    }

    public void dfs(int[][] maze, int[] start, int[][] distance) {
        int[][] dirs={{0,1}, {0,-1}, {-1,0}, {1,0}};
        for (int[] dir: dirs) {
            int x = start[0] + dir[0];
            int y = start[1] + dir[1];
            int count = 0;
            while (x >= 0 && y >= 0 && x < maze.length && y < maze[0].length && maze[x][y] == 0) {
                x += dir[0];
                y += dir[1];
                count++;
            }
            if (distance[start[0]][start[1]] + count < distance[x - dir[0]][y - dir[1]]) {
                distance[x - dir[0]][y - dir[1]] = distance[start[0]][start[1]] + count;
                dfs(maze, new int[]{x - dir[0],y - dir[1]}, distance);
            }
        }
    }
}

