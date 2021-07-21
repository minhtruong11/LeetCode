class Solution {
    
    boolean isPalindrome(String s) {
        for(int i=0, j=s.length()-1; i<=j; i++, j--) {
            if(s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }
    
    void bt(String s, int idx, List<String> part, List<List<String>> result) {
        if(idx==s.length()) {
            result.add(new ArrayList<>(part));
            return;
        }
        
        for(int i=idx; i<s.length(); i++) {
            String str = s.substring(idx, i+1);
             if(isPalindrome(str)) {
                 part.add(str);
                 bt(s, i+1, part, result);
                 part.remove(part.size()-1);
             }    
        }
    }
    
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        bt(s, 0, new ArrayList<>(), result);
        return result;
    }
}