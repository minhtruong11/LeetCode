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
        
        return res.stream().mapToInt(i->i).toArray();
    }
}