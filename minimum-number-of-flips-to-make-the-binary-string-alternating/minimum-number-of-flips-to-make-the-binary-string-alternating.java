class Solution {
    public int minFlips(String s) {
        int n=s.length();
        s += s;
        StringBuilder sb1 = new StringBuilder(), sb2 = new StringBuilder();
        
        for(int i=0; i<s.length(); i++) {
            if(i%2 != 0) {
                sb1.append("1");
                sb2.append("0");
            } else {
                sb1.append("0");
                sb2.append("1");    
            }
        }
        
        int flip1=0, flip2=0, ans=1000000000;
        
        for(int i=0; i<s.length(); i++) {
            if(sb1.charAt(i) != s.charAt(i)) {
                flip1++;
            }
            if(sb2.charAt(i) != s.charAt(i)) {
                flip2++;
            }
            
            if(i>=n) {
                if(sb1.charAt(i-n) != s.charAt(i-n)) {
                    flip1--;
                }
                if(sb2.charAt(i-n) != s.charAt(i-n)) {
                    flip2--;
                }   
            }
            
            if(i>=n-1) {
                ans = Math.min(ans, Math.min(flip1, flip2));
            }
            
        }
        
        return ans;
    }
}