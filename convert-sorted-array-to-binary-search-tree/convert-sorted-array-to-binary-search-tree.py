# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    
    def divide(self, nums: List[int], i, j) -> Optional[TreeNode]:
        if j-i+1 < 1:
            return None
        
        if j-i+1 == 1:
            return TreeNode(nums[i])
        
        mid = i+(j-i)//2
        root = TreeNode(nums[mid])
        root.left = self.divide(nums, i, mid-1)
        root.right = self.divide(nums, mid+1, j)
        return root
    
    def sortedArrayToBST(self, nums: List[int]) -> Optional[TreeNode]:
        n = len(nums)
        return self.divide(nums, 0, n-1)
