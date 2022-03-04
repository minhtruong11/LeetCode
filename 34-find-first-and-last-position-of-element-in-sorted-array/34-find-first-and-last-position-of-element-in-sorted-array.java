class Solution {
    
    int findBound(int[] nums, int target, boolean isLeftBound) {
        
        int low = 0, high = nums.length-1;
        int mid;
        int idx = -1;
        
        if (isLeftBound) {
            while (low <= high) {
                mid = low + (high - low) / 2;
                
                if (nums[mid] == target) {
                    idx = mid;
                    high = mid-1;
                } else if (nums[mid] > target) {
                    high = mid-1;
                } else {
                    low = mid+1;
                }
            }
        } else {
            while (low <= high) {
                mid = low + (high - low) / 2;
                
                if (nums[mid] == target) {
                    idx = mid;
                    low = mid+1;
                } else if (nums[mid] > target) {
                    high = mid-1;
                } else {
                    low = mid+1;
                }
            }
        }
        
        return idx;
    }
    
    public int[] searchRange(int[] nums, int target) {
        
        int[] res = new int[2];
        
        res[0] = findBound(nums, target, true);
        res[1] = findBound(nums, target, false);
        
        return res;
    }
}