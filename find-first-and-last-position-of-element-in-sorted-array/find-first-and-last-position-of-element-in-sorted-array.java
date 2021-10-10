class Solution {
    
    int findLeftBound(int[] nums, int target) {
        int n = nums.length;
        int left=0, right=n-1;
        int ans=-1;
        
        while(left<=right) {
            int mid = left + (right-left)/2;
            if(nums[mid] == target) {
                ans = mid;
                right = mid-1;
            } else if(nums[mid] > target) {
                right = mid-1;
            } else {
                left = mid+1;
            }
        }
        
        return ans;
    }
    
    int findRightBound(int[] nums, int target) {
        int n = nums.length;
        int left=0, right=n-1;
        int ans=-1;
        
        while(left<=right) {
            int mid = left + (right-left)/2;
            if(nums[mid] == target) {
                ans = mid;
                left = mid+1;
            } else if(nums[mid] > target) {
                right = mid-1;
            } else {
                left = mid+1;
            }
        }
        
        return ans;
    }
    
    public int[] searchRange(int[] nums, int target) {
        int leftBound = findLeftBound(nums, target);
        int rightBound = findRightBound(nums, target);
        
        return new int[]{leftBound, rightBound};
    }
}