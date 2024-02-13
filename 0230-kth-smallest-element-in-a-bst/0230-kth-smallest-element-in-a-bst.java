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
     private int result = 0;
    
     public int kthSmallest(TreeNode root, int k) {
        count = 0; // Reset count for each call
        inorderTraversal(root, k);
        return result;
     }
    
     private void inorderTraversal(TreeNode node, int k) {
        if (node == null || count >= k)
            return;
        
        // Traverse left subtree
        inorderTraversal(node.left, k);
        
        // Process current node
        count++;
        if (count == k) {
            result = node.val;
            return;
        }
        
        // Traverse right subtree
        inorderTraversal(node.right, k);
    }
}