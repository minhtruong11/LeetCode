/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null) {
			return 0;
		}
		
		int lDia = diameterOfBinaryTree(root.left);
		int rDia = diameterOfBinaryTree(root.right);
		
		int lHeight = getHeight(root.left);
		int rHeight = getHeight(root.right);
		
		return Math.max(lHeight + rHeight + 2, Math.max(lDia, rDia));
	}
	
	int getHeight(TreeNode root) {
		if(root==null)	return -1;
		return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
	}
}