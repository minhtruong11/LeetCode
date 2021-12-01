class Solution {
    public void moveZeroes(int[] nums) {
        int left=0;
        
        for(int i=0; i<=nums.length-1; i++) {
            if(nums[i] != 0) {
                swap(nums, i, left);
                left++;
            }
        }
    }
    
    void swap(int[] arr, int i, int j) {
        int t= arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}