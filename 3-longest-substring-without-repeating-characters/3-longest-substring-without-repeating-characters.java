class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        if (s.length() == 0)  return 0;
        
        Set<Character> set = new HashSet<>();
        int start = 0;
        int len = Integer.MIN_VALUE;
        
        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            
            if (!set.contains(c)) {
                set.add(c);
                len = Math.max(len, i-start+1);
            } else {
                while (start < i+1 && set.contains(c)) {
                    set.remove(s.charAt(start));
                    start++;
                }
                set.add(c);
            }
        }
        
        return len;
    }
}