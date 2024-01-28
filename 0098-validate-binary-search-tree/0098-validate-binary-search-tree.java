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
    public boolean isValidBST(TreeNode root) {
        if(root == null) return true;
        
        return dfs(root, null, null);
        
    }
    
    private boolean dfs(TreeNode node, Integer min, Integer max) {
        if(node == null) return true;
        
        if((min != null && min >= node.val) || (max != null && max <= node.val)) return false;
        
        return dfs(node.left, min, node.val) && dfs(node.right, node.val, max);
    }
}