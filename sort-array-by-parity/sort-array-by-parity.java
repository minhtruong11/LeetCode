class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int left=0, right=nums.length-1;
        
        for(int i=0; i<=right; ) {
            if(nums[i] % 2 == 0) {
                swap(nums, i, left);
                left++;
                i++;
            } else {
                swap(nums, i, right);
                right--;
            }
        }
        
        return nums;
    }
    
    public void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}