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
    public boolean isBalanced(TreeNode root) {
        int[] result = subtreeBalanceCheck(root);
        
        return result[0] == 1;
    }
    
    // Returns two elements where the first is whether a subtree is balanced and the second 
    // is the height of the subtree.
    private int[] subtreeBalanceCheck(TreeNode node) {
        // The base case is when the node is null, return true (1) and 0 for height.
        if(node == null) return new int[]{1, 0};
        
        int[] left = subtreeBalanceCheck(node.left);
        int[] right = subtreeBalanceCheck(node.right);
        
        // If any of the left or right subtrees is not balanced, then return 0 as false.
        if(left[0] == 0 || right[0] == 0) return new int[]{0, 0};
        
        int isBalanced = Math.abs(left[1] - right[1]) <= 1 ? 1 : 0;
        
        return new int[]{isBalanced, Math.max(left[1], right[1]) + 1};
    }
    
   
}