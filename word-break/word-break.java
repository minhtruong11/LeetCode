class Solution {
    
    boolean bt(String s, int i, List<String> w, Boolean[] memo) {
		if(i>s.length()) {
			return false;
		}
		if(i==s.length()) {
			return true;
		}
		if(memo[i] != null) return memo[i];
        
        boolean flag = false;
		for(String word : w) {
			if(s.substring(i).startsWith(word)) {
				flag = flag || bt(s, i+word.length(), w, memo); 
			}
		}
		
        memo[i] = flag;
		return memo[i];
	}
    
    public boolean wordBreak(String s, List<String> wordDict) {
        return bt(s, 0, wordDict, new Boolean[s.length()]);
    }
}