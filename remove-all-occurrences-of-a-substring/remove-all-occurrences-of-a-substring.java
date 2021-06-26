class Solution {
    public String removeOccurrences(String s, String part) {
        int n = s.length();
        int m = part.length();
        
        StringBuilder sb = new StringBuilder(s);
        
        do {
            int i = sb.indexOf(part);
            if(i==-1)   break;
            sb.replace(i, i+m, "");
        } while(true);
        
        return sb.toString();
    }
}