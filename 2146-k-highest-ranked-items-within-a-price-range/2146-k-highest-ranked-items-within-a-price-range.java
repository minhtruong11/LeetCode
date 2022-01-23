class Solution {
    public List<List<Integer>> highestRankedKItems(int[][] grid, int[] pricing, int[] start, int k) {
        int m = grid.length;
        int n = grid[0].length;
        Deque<int[]> q = new ArrayDeque<>(); 
        Set<Integer> visited = new HashSet<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((l1, l2) -> {
            if (l1[2] != l2[2]) {
                return l1[2] - l2[2];
            } else if (grid[l1[0]][l1[1]] != grid[l2[0]][l2[1]]){
                return grid[l1[0]][l1[1]] - grid[l2[0]][l2[1]]; 
            } else if (l1[0] != l2[0]) {
                if (l1[0] < l2[0]) {
                    return -1;
                } else return 1;
            } else {
                if (l1[1] < l2[1]) {
                    return -1;
                } else return 1;
            }
        });
        
        q.offerLast(start);
        visited.add(start[0] * n + start[1]);
        int step = 1;
        if (grid[start[0]][start[1]] != 1 && 
            grid[start[0]][start[1]] >= pricing[0] &&
            grid[start[0]][start[1]] <= pricing[1]) {
                pq.add(new int[] {start[0], start[1], 0});    
        }
        
        
        while (!q.isEmpty()) {
            int sz = q.size();
            while (sz-- > 0) {
                int[] node = q.pollFirst();
                
                int[] dirX = { 1, 0,  0, -1};
                int[] dirY = { 0, 1, -1,  0};
                
                for (int d=0; d<4; d++) {
                    int[] pos = new int[] {node[0] + dirX[d], node[1] + dirY[d]};
                    
                    if (pos[0] < 0 ||
                        pos[0] >= m ||
                        pos[1] < 0 ||
                        pos[1] >= n ||
                        visited.contains(pos[0] * n + pos[1]) || 
                        grid[pos[0]][pos[1]] == 0) {
                        continue;
                    }
                    
                    if (grid[pos[0]][pos[1]] >= pricing[0] &&
                        grid[pos[0]][pos[1]] <= pricing[1]) {
                        pq.add(new int[] {pos[0], pos[1], step});    
                    }
                    
                    q.offerLast(pos);
                    visited.add(pos[0] * n + pos[1]);
                }
            }
            step += 1;
        }
        
        List<List<Integer>> res = new ArrayList<>();
        
        while (!pq.isEmpty() && k-- > 0) {
            int[] node = pq.poll();
            List temp = new ArrayList<>();
            temp.add(node[0]);
            temp.add(node[1]);
            res.add(temp);
        }
        
        return res;
    }
}