class Solution {
    
    void dfs(int[][] isConnected, int n, int i, Set<Integer> visited) {
        if (visited.contains(i))    return;
        visited.add(i);
        
        for (int j=0; j<n; j++) {
            if (isConnected[i][j] == 1) {
                dfs(isConnected, n, j, visited);
            }
        }
    }
    
    public int findCircleNum(int[][] isConnected) {
        Set<Integer> visited = new HashSet<>();
        int n = isConnected.length;
        int count = 0;
        
        for (int i=0; i<n; i++) {
            if (!visited.contains(i)) {
                dfs(isConnected, n, i, visited);
                count++;
            }
        }
        
        return count;
    }
}