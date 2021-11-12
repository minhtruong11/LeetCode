# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def findMode(self, root: Optional[TreeNode]) -> List[int]:
        
        def inorder(root, order):
            if root is None:
                return
            inorder(root.left, order)
            order.append(root.val)
            inorder(root.right, order)
        
        order = []
        inorder(root, order)
        
        counts = Counter(order)
        max_count = max(counts.values())
        
        res = []
        
        for val, count in counts.items():
            if max_count == count:
                res.append(val)
                
        return res
        
        