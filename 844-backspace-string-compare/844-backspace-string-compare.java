class Solution {
    public boolean backspaceCompare(String s, String t) {
        Deque<Character> stack1 = new ArrayDeque<>();
        Deque<Character> stack2 = new ArrayDeque<>();
        
        for (char c : s.toCharArray()) {
            if (c == '#') {
                if (!stack1.isEmpty()) {
                    stack1.poll();
                }
            } else {
                stack1.push(c);        
            }
        }
        
        for (char c : t.toCharArray()) {
            if (c == '#') {
                if (!stack2.isEmpty()) {
                    stack2.poll();
                }
            } else {
                stack2.push(c);        
            }
        }
        
        StringBuilder ts = new StringBuilder();
        StringBuilder tt = new StringBuilder();
        
        while (!stack1.isEmpty()) {
            ts.append(stack1.poll());
        }
        
        while (!stack2.isEmpty()) {
            tt.append(stack2.poll());
        }
        
        return ts.toString().equals(tt.toString());
    }
}