class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> st = new ArrayDeque<>();
        
        for(int asteroid : asteroids) {
            while(!st.isEmpty() && st.peek() > 0 && asteroid < 0 && st.peek() < -asteroid) {
                st.pop();
            } 
            if(!st.isEmpty() && st.peek() > 0 && asteroid < 0 && st.peek() == -asteroid) {
                st.pop();
                continue;
            }
            if(!st.isEmpty() && st.peek() > 0 && asteroid < 0 && st.peek() > -asteroid) {
                continue;
            } 
            st.push(asteroid);
        }
        
        int[] res = new int[st.size()];
        int i=0;
        while(!st.isEmpty()) {
            res[i++] = st.pollLast();
        }
        return res;
    }
}