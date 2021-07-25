class Solution {
    public int[] canSeePersonsCount(int[] heights) {
        int n = heights.length;
        int[] res = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();
        stack.offerLast(heights[n-1]);
        for(int i=n-2; i>=0; i--) {
            int count=0;
            while(!stack.isEmpty() && stack.peekLast() < heights[i]) {
                count++;
                stack.pollLast();
            }
            res[i] = count + (stack.size() == 0 ? 0 : 1);
            stack.offerLast(heights[i]);
        }
        
        return res;
    }
}