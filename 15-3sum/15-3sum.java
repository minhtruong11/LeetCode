class Solution {
    
    List<List<Integer>> res = new ArrayList<>();
    
    public void findPair(int[] nums, int k, int idx) {
        int left = idx+1, right = nums.length-1;
        
        while (left < right) {
            if (nums[left] + nums[right] == k) {
                res.add(List.of(-k, nums[left], nums[right]));
                left++;
                right--;
                while (left < right && nums[left] == nums[left-1]) left++;
                while (right > left && nums[right] == nums[right+1])    right--;
            } else if (nums[left] + nums[right] < k) {
                left++;
            } else {
                right--;
            }
        }
    }
    
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        
        for (int i=0; i<nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1])  continue;
            findPair(nums, -nums[i], i); 
        }
        
        return res;
    }
}