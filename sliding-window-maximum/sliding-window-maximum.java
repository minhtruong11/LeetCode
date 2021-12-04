class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dq = new ArrayDeque<>();
        List<Integer> ans = new ArrayList<>();
        
        for(int i=0; i<nums.length; i++) {    
            while(!dq.isEmpty() && dq.peekLast() < nums[i]) {
                dq.pollLast();
            }
            dq.offerLast(nums[i]);
            if(i>=k-1) {
                ans.add(dq.peekFirst());
                if(!dq.isEmpty() && nums[i-k+1] == dq.peekFirst()) {
                    dq.pollFirst();
                }
            }
        }
        
        int[] res = new int[ans.size()];
        int i=0;
        
        for(int ele : ans) {
            res[i++] = ele;
        }
        
        return res;
    }
}