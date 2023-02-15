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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inOrderTraverse(root, list);
        return list;
        
    }
    
    private void inOrderTraverse(TreeNode node, List<Integer> list) {
        if(node == null) return;
        
        inOrderTraverse(node.left, list);
        list.add(node.val);
        inOrderTraverse(node.right, list);
        
    }
}