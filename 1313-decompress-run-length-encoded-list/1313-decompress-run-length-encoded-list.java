class Solution {
    public int[] decompressRLElist(int[] nums) {
        List<Integer> res = new ArrayList<>();
        
        for (int i=0; i<nums.length-1; i+=2) {
            int freq = nums[i];
            int num = nums[i+1];
            
            for (int j=1; j<=freq; j++) {
                res.add(num);
            }
        }
        
        int[] arr = new int[res.size()];
        int i=0;
        
        for (int num : res) {
            arr[i++] = num;
        }
        
        return arr;
    }
}