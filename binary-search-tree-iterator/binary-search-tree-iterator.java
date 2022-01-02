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
class BSTIterator {

   private Stack<TreeNode> stack = new Stack<>();

    public BSTIterator(TreeNode root) {
        // find the minimum point and make it the starting point by putting it on the stack top
        // the next node will always be on the stack top
        while(root != null) {
            stack.push(root);
            root = root.left;
        }
    }
    
    // inorder -> left, root, right
    public int next() {
        // peek to get the next instad of poppping because the stack has to be re-arranged for next iteration
        TreeNode current = stack.peek();
        TreeNode node = current;

        // if current node has a right node, then get the least possible node on its right tree
        if(node.right != null) {
            // as it has a right sub-tree, the next to be returned will exist there
            // current node will be used for later backtracking, don't pop it
            node = node.right;
            // looks like another initialization
            while(node != null) {
                stack.push(node);
                node = node.left;
            }
        // if current node has no right node, return 
        } else {
            // current node is the end of the sub-tree we are travasing here 
            // it will not be used again, so pop it
            stack.pop();
            // backtrack by removing current sub-tree and moving up
            while (this.hasNext() && stack.peek().right == node) {
                node = stack.pop();
            }
        }
        return current.val;
    }
    
    public boolean hasNext() {
        return !stack.isEmpty();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */