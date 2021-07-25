class Solution {
    public int smallestChair(int[][] times, int targetFriend) {
        int targetStart = times[targetFriend][0];
        Arrays.sort(times, (r1, r2) -> r1[0] - r2[0]);
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0; i<times.length; i++) {
            pq.offer(i);
        }
        
        PriorityQueue<int[]> end = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        
        for(int i=0; i<times.length; i++) {
            while(!end.isEmpty() && end.peek()[0] <= times[i][0]) {
                pq.offer(end.poll()[1]);
            }
            if(times[i][0] == targetStart) {
                return pq.peek();
            }
            end.offer(new int[]{times[i][1], pq.poll()});
        }
        
        return -1;
    }
}