class Solution {
    public String defangIPaddr(String address) {
        String[] bytes = address.split("\\.");
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<bytes.length; i++) {
            String _byte = bytes[i];
            sb.append(_byte);
            if (i < bytes.length-1) {
                sb.append("[.]");
            }
        }
        return sb.toString();
    }
}