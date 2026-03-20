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
        List<Integer> res = new ArrayList<>();
        inOrderTraversal(res, root);
        return res;
    }

    private void inOrderTraversal(List<Integer> res, TreeNode node) {
        if(node == null) return;

        inOrderTraversal(res, node.left);
        res.add(node.val);
        inOrderTraversal(res, node.right);
    }
}