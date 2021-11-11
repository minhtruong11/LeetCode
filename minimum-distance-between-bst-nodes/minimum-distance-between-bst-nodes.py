# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def minDiffInBST(self, root: Optional[TreeNode]) -> int:
        def helper(root):
            if root == None:
                return
            helper(root.left)
            
            if self.prev:
                self.diff = min(self.diff, abs(self.prev.val - root.val))
            self.prev = root
            
            helper(root.right)
        
        self.diff = float('Inf')
        self.prev = None
        helper(root)
        return self.diff