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
    public int[] findMode(TreeNode root) {
        Map<Integer, Integer> freq = new HashMap<>();
        traverse(root, freq);
        
        int count = Integer.MIN_VALUE;
        List<Integer> res = new ArrayList<>();
        
        for (int key : freq.keySet()) {
            if (freq.get(key) >= count) {
                count = freq.get(key);
            }
        }
        
        for (int key : freq.keySet()) {
            if (freq.get(key) == count) {
                res.add(key);
            }
        }
        
        int[] arr = new int[res.size()];
        
        for (int i=0; i<arr.length; i++) {
            arr[i] = res.get(i);
        }
        
        return arr;
    }
    
    public void traverse(TreeNode root, Map<Integer, Integer> freq) {
        if (root == null) return;
        if (!freq.containsKey(root.val)) {
            freq.put(root.val, 0);
        }
        freq.put(root.val, freq.get(root.val) + 1);
        traverse(root.left, freq);
        traverse(root.right, freq);
    }
}