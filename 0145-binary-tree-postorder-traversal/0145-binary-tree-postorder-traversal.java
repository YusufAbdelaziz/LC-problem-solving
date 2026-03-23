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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        postOrderTraversalHelper(res, root);
        return res;
    }

    private void postOrderTraversalHelper(List<Integer> res, TreeNode node) {
        if(node == null) return;

        postOrderTraversalHelper(res, node.left);
        postOrderTraversalHelper(res, node.right);
        res.add(node.val);
    }
}