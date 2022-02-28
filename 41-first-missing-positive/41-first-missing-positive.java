class Solution {
    public int firstMissingPositive(int[] nums) {
        
        boolean hasOne = false;
        
        for (int num : nums) {
            if (num == 1) {
                hasOne = true;
                break;
            }
        }
        
        if (!hasOne)    return 1;

        for (int i=0; i<nums.length; i++) {
            if (nums[i] <= 0 || nums[i] > nums.length) {
                nums[i] = 1;
            }
        }
        
        
        for (int num : nums) {
            if (Math.abs(num) == nums.length && Math.abs(num) > 0) {
                nums[0] = -nums[0];
            } else if (nums[Math.abs(num)] > 0){
                nums[Math.abs(num)] = -nums[Math.abs(num)];
            }
        }

        // for (int num : nums) {
        //     System.out.printf("%d ", num);
        // }
        // System.out.println();

        for (int i=1; i<nums.length; i++) {
            if (nums[i] > 0)   return i;
        }

        return nums[0] > 0 ? nums.length : nums.length + 1;
    }
}

/**

    [7, 8, 9, 11, 12]
    0 1 2 3 4 5 6 7 8 9 10 11 12
   [. . . . . . . 7 8 9 .  11 12]

    [1 2 9 4 5]
    3

*/