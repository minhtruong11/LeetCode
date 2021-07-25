class Solution {
    public String maximumNumber(String n, int[] change) {
        StringBuilder num = new StringBuilder(n);
        boolean mutation = false;
        for(int i=0; i<num.length(); i++) {
            int digit = num.charAt(i) - '0';
            char toPut = (char)('0' + Math.max(digit, change[digit]));
            if(digit > change[digit] && mutation) {
                break;
            }
            if(!mutation && Math.max(digit, change[digit]) != digit) {
                mutation = true;
            }
            num.setCharAt(i, toPut);
        }
        
        return num.toString();
    }
}