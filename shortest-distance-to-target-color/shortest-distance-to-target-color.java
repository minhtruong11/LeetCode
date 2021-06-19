class Solution {
    
    public int search(List<Integer> arr, int k) {
        int left =0, right=arr.size()-1;
        int ans = -1;
        
        while(left<=right) {
            int mid = left + (right-left)/2;
            if(arr.get(mid) == k) {
                return 0;
            }
            if(arr.get(mid) < k) {
                ans = mid;
                left = mid+1;
            } else {
                right = mid-1;
            } 
        }
        
        System.out.println(ans);
        
        if(ans==-1) return -k+arr.get(0);
        
        if(ans==arr.size()-1 || k-arr.get(ans) < -k+arr.get(ans+1)) {
            return k-arr.get(ans);
        }
        
        return -k+arr.get(ans+1);
        
    }
    
    public List<Integer> shortestDistanceColor(int[] colors, int[][] queries) {
        
        List<List<Integer>> posColor = new ArrayList<>();
        
        for(int i=0; i<3; i++) {
            posColor.add(new ArrayList<>());
        }
        
        for(int i = 0; i<colors.length; i++) {
            posColor.get(colors[i]-1).add(i);
        }
        
        System.out.println(posColor);
        
        List<Integer> res = new ArrayList<>();
        
        for(int i=0; i<queries.length; i++) {
            int idx = queries[i][0];
            int clr = queries[i][1];
            
            if(posColor.get(clr-1).size() == 0) {
                res.add(-1);
                continue;
            }
            res.add(search(posColor.get(clr-1), idx));
        }
        
        return res;
    }
}