class Solution {
    public int longestValidParentheses(String s) {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(-1);
        
        int maxValid = 0;
        
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if(c == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if(stack.size() != 0) {
                    maxValid = Math.max(maxValid, i-stack.peek());
                } else stack.push(i);
            }
        }
        
        return maxValid;
    }
}