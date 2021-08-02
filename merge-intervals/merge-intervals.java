class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0]-b[0]);
		
		List<int[]> result = new ArrayList<>();
		
		for(int i=0; i<intervals.length; i++) {
			if(!result.isEmpty() && 
			   result.get(result.size()-1)[1] >= intervals[i][0]) {
				
				result.get(result.size()-1)[1] = 
					Math.max(intervals[i][1], result.get(result.size()-1)[1]);
			} else {
				result.add(intervals[i]);
			}
		}
		
		if(result.size() == intervals.length) {
			return intervals;
		}
		
		int[][] ans = new int[result.size()][2];
		int i=0;
		for(int[] interval : result) {
			ans[i++] = interval;
		}
		
		return ans;
    }
}