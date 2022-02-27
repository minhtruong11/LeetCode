class Solution {
    public long minimumTime(int[] time, int totalTrips) {
        Arrays.sort(time);
        long low = 0, high = Long.MAX_VALUE; 
        long minTime = Long.MAX_VALUE;
        
        while (low <= high) {
            long mid = low + (high - low) / 2;
            
            int trips = 0;
            for (int t : time) {
                trips += mid / t;
                
                if (trips < 0) {
                    high = mid-1;
                    break;
                }
            }
            
            if (trips < 0)  continue;
            
            if (trips >= totalTrips) {
                minTime = Math.min(mid, minTime);
                high = mid-1;
            } else {
                low = mid+1;
            }
        }
        
        return minTime;
    }
}