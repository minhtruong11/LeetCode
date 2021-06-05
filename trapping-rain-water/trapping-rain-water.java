class Solution {
    public int trap(int[] height) {
        int n = height.length;
        if(n==0)    return 0;
        int leftMax = height[0];
        int rightMax = height[n-1];
        int water = 0;
        int left=1, right=n-2;
        
        while(left<=right) {
            if(leftMax < rightMax) {
                water += leftMax > height[left] ? leftMax - height[left] : 0;
                leftMax = Math.max(leftMax, height[left]);
                left++;
            } else {
                water += rightMax > height[right] ? rightMax - height[right] : 0;
                rightMax = Math.max(rightMax, height[right]);
                right--;
            }
        }
        
        return water;
    }
}