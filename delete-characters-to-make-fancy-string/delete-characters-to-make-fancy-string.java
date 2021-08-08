class Solution {
    public String makeFancyString(String s) {
        int count=0;
        char c = '-';
        int del=0;
        StringBuilder sb = new StringBuilder();
        
        for(int i=0; i<s.length(); i++) {
            if(i == 0 || c != s.charAt(i)) {
                count = 1;
                c = s.charAt(i);
                sb.append(c);
            } else {
                count++;
                if(count >= 3) {
                    del++;
                } else {
                    sb.append(c);
                }
            }
        }
        
        return sb.toString();
    }
}