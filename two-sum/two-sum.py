class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        left = 0
        right = len(nums) - 1
        
        mp = {}
        
        for idx, num in enumerate(nums):
            if target - num in mp:
                return [idx, mp[target-num]]
            mp[num] = idx    
        
        return [-1, -1]
        