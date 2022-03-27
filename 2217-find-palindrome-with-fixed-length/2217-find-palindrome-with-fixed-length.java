class Solution {
    public long[] kthPalindrome(int[] queries, int intLength) {
        long[] res = new long[queries.length];
        int k=0;
        
        long half = (long)Math.ceil(intLength/2.0);
        long start = (long)Math.pow(10, half-1);
        long end = (long)(Math.pow(10, half) - 1);

        for (int i=0; i<queries.length; i++) {
            if (queries[i] <= end - start + 1) {
                String firstHalf = (start + (queries[i]-1)) + "";
                String secondHalf = (new StringBuilder(firstHalf))
                                    .reverse()
                                    .toString()
                                    .substring(intLength%2);
                res[k++] = Long.parseLong(firstHalf + secondHalf);
            } else res[k++] = -1;
        }
        
        return res;
    }
}