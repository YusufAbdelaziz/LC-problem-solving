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
    
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(subRoot == null || isSameTree(root, subRoot)) return true;
        if(root == null) return false;
        
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
      
    }
    
    
    private boolean isSameTree(TreeNode tree1, TreeNode tree2) {
        if(tree1 == null && tree2 == null) return true;
        if((tree1 == null || tree2 == null) || (tree1.val != tree2.val)) return false;
        
        return isSameTree(tree1.right, tree2.right) && isSameTree(tree1.left, tree2.left);
    }
}