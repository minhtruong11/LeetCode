class Solution {
    public String defangIPaddr(String address) {
         StringBuilder sb = new StringBuilder(address);
        int n = sb.length();
        for(int i = 0; i<sb.length(); i++){
            if(sb.charAt(i) == '.' && sb.charAt(i+1) == ']'){
                continue;
            }else if(sb.charAt(i) == '.') {
            	sb.insert(i, "[");
                sb.insert(i+2, "]");
            }
        }
        return(sb.toString());
    }
}