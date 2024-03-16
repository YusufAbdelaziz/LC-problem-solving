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
    private int count = 0;
    public int goodNodes(TreeNode root) {
        goodNodesHelper(root, Integer.MIN_VALUE);
        return count;
    }
    
    private void goodNodesHelper(TreeNode node, int max) {
        if(node == null) {
            return;
        }
        
        if(node.val >= max) count++;
        
        goodNodesHelper(node.right, Math.max(max, node.val));
        goodNodesHelper(node.left, Math.max(max, node.val));
    }
}