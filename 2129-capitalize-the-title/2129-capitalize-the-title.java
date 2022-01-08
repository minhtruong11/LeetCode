class Solution {
    public String capitalizeTitle(String title) {
        StringBuilder sb = new StringBuilder();
        
        for (String word : title.split(" ")) {
            if (word.length() == 1 || word.length() == 2) {
                sb.append(word.toLowerCase() + " ");
            } else {
                sb.append(word.substring(0,1).toUpperCase() + word.substring(1).toLowerCase() + " ");
            }    
        }
        
        return sb.toString().trim();
        
    }
}