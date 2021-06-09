class Solution {
    public String longestPalindrome(String s) {
        int[][] memo = new int[s.length()][s.length()];
        Arrays.stream(memo).forEach(row -> {
            Arrays.fill(row, -1);
        });

        int[] arr = lps(s, s.length(), 0, s.length()-1, memo);
        Arrays.stream(arr).forEach(e -> System.out.printf("%d ", e));
        return s.substring(arr[0], arr[0]+arr[2]);
        //if(arr[1] == s.length()-1)    arr[1]++;
        // StringBuffer sb1 = new StringBuffer(s.substring(arr[0], arr[0]+arr[2]));
        // StringBuffer sb2 = new StringBuffer(s.substring(arr[1]-arr[2]+1, arr[1]+1));
        // StringBuffer sb3 = new StringBuffer(s.substring(arr[0], arr[0]+arr[2]));
        // if(sb1.toString().equals(sb3.reverse().toString()))
        //     return s.substring(arr[0], arr[0]+arr[2]);
        // else return sb2.toString();
        // System.out.println();
        // for(int i=0; i<memo.length; i++) {
        //     for(int j=memo[0].length-1; j>=0; j--) {
        //         if(memo[i][j] == arr[2]) {
        //             System.out.printf("%d %d\n", i, j);
        //             return s.substring(i, j+1);
        //         }
        //     }
        // }
        
        // return s.substring(0,1);
    }

    
    int[] lps(String s, int n, int left, int right, int[][] memo) {
        if(right<left)  return new int[]{left, right, 0};;
        if(right==left) {
            memo[left][right] = 1;
            return new int[]{left, right, 1};
        }
        if(memo[left][right] != -1) {
            return new int[]{left, right, memo[left][right]};
        }
        if(s.charAt(left) == s.charAt(right)) {
            int[] x = lps(s, n, left+1, right-1, memo);
            if(right-left-1 == x[2]) {
                memo[left][right] = x[2]+2;
                return new int[]{left, right, memo[left][right]};
            }
        }
        int[] one = lps(s, n, left+1, right, memo);
        int[] two = lps(s, n, left, right-1, memo);

        memo[left][right] = Math.max(one[2], two[2]);

        if(memo[left][right] == one[2]) {
            return new int[]{one[0], one[1], memo[left][right]};        
        } else {
            return new int[]{two[0], two[1], memo[left][right]};
        }
        
    }

}