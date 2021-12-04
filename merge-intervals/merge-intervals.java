class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        
        Deque<int[]> dq = new ArrayDeque<>();
        dq.offerLast(intervals[0]);
        
        for(int[] interval : intervals) {
            if(dq.peekLast()[1] >= interval[0]) {
                dq.peekLast()[1] = Math.max(dq.peekLast()[1], interval[1]);
            } else {
                dq.offerLast(interval);
            }
        }
        
        int[][] res = new int[dq.size()][2];
        int i=0;
        
        while(!dq.isEmpty()) {
            res[i++] = dq.pollFirst();
        }
        
        return res;
    }
}