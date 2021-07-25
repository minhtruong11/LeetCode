class Solution {
    int ans;
    
    int getScore(int a[], int b[]) {
        int count=0;
        
        for(int i=0; i<a.length; i++) {
            if(a[i] == b[i]) {
                count++;
            }
        }
        
        return count;
    }
    
    void bt(int[][] students, int[][] mentors, Boolean[] visited, int pos, int score) {
        if(pos == students.length) {
            ans = Math.max(ans, score);
            return;
        }
        
        for(int i=0; i<mentors.length; i++) {
            if(!visited[i]) {
                visited[i] = true;
                bt(
                    students, 
                    mentors, 
                    visited, 
                    pos+1, 
                    score + getScore(students[pos], mentors[i])
                );
                visited[i] = false;
            } 
        }
    }
    
    public int maxCompatibilitySum(int[][] students, int[][] mentors) {
        ans = Integer.MIN_VALUE;
        Boolean[] visited = new Boolean[mentors.length];
        Arrays.fill(visited, false);
        bt(students, mentors, visited, 0, 0);
        return ans;
    }
}