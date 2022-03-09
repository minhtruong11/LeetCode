class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        
        if (s.length() < p.length())    return new ArrayList<Integer>();
        
        int pLen = p.length();
        int sLen = s.length();
        int[] freqMapP = getFreqMap(p);
        List<Integer> res = new ArrayList<>();
        int[] windowMap = getFreqMap(s.substring(0, pLen));
        
        if (isFreqMapSame(windowMap, freqMapP)) {
            res.add(0);
        }
        
        for (int end=pLen; end<s.length(); end++) {
            windowMap[s.charAt(end-pLen)-'a']--;
            windowMap[s.charAt(end)-'a']++;
            if (isFreqMapSame(windowMap, freqMapP)) {
                res.add(end-pLen+1);
            }
        }
        
        return res;
    }
    
    public boolean isFreqMapSame(int[] map1, int[] map2) {
        for (int i=0; i<26; i++) {
            if (map1[i] != map2[i]) {
                return false;
            }
        }
        return true;
    }
    
    public int[] getFreqMap(String s) {
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c-'a']++;
        }
        return count;
    }
}