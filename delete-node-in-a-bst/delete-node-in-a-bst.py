# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    
    def getSuccessor(self, root):
        if root is None:
            return None
        root = root.right
        
        while root != None and root.left != None:
            root = root.left
            
        return root
    
    def deleteNode(self, root: Optional[TreeNode], key: int) -> Optional[TreeNode]:
        if root is None:
            return root
        if root.val < key:
            root.right = self.deleteNode(root.right, key)
        elif root.val > key:
            root.left = self.deleteNode(root.left, key)
        else:
            if root.right is None:
                node = root.left
                return node
            if root.left is None:
                node = root.right
                return node
            
            successor = self.getSuccessor(root)
            root.val = successor.val
            root.right = self.deleteNode(root.right, successor.val)
        
        return root