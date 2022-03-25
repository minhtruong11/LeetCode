class Solution {
    public int minAddToMakeValid(String S) {
        Deque<Character> stack = new ArrayDeque<>();
        int count = 0;

        for (char c : S.toCharArray()) {
            if (c == '(') {
                stack.offerLast(c);
            } else {
                if (stack.isEmpty()) {
                    count++;
                } else {
                    stack.pollLast();
                }
            }
        }

        return count + stack.size();
    }
}