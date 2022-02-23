class Solution {
    
    public void _rev(char[] s, int i) {
        if (i >= s.length / 2)  return;
        char temp = s[i];
        s[i] = s[s.length - i - 1];
        s[s.length - i - 1] = temp;
        
        _rev(s, i+1);
    }
    
    public void reverseString(char[] s) {
        _rev(s, 0);
    }
}