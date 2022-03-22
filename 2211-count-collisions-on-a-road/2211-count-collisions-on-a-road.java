class Solution {
    public int countCollisions(String directions) {
        StringBuilder sb = new StringBuilder(directions);
        int n = directions.length();
        Deque<Character> stack = new ArrayDeque<>();
        int count = 0;
        
        for (int i=0; i<n; i++) {
            char dir = sb.charAt(i);
            if (i == 0) {
                stack.offerLast(dir);
            } else {
                char prev = stack.peekLast();
                if (prev == 'S' && dir == 'L') {
                    count += 1;
                    stack.offerLast('S');
                } else if (prev == 'R' && dir == 'S') {
                    while (!stack.isEmpty() && stack.peekLast() == 'R') {
                        count += 1;
                        stack.pollLast();
                    }
                    stack.offerLast('S');
                } else if (prev == 'R' && dir == 'L') {
                    count += 2;
                    stack.pollLast();
                    
                    while (!stack.isEmpty() && stack.peekLast() == 'R') {
                        count++;
                        stack.pollLast();
                    }
                    stack.offerLast('S');
                } else {
                    stack.offerLast(dir);
                }
            }
        }
        
        return count;
    }
}