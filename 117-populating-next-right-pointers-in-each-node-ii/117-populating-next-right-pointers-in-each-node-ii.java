/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if (root == null)   return null;
        Deque<Node> queue = new ArrayDeque<>();
        queue.offerLast(root);
        
        while (!queue.isEmpty()) {
            int sz = queue.size();
            Node prev = null;
            for (int i=1; i<=sz; i++) {
                Node node = queue.pollFirst();
                if (i == 1) {
                    node.next = null;
                } else {
                    prev.next = node;
                }
                prev = node;
                if (node.left != null) {
                    queue.offerLast(node.left);
                } 
                if (node.right != null) {
                    queue.offerLast(node.right);
                }
            }
        }
        
        return root;
    }
}