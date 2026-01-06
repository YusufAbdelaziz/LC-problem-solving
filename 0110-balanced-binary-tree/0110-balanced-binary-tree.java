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
        return dfs(root)[0] == 1;
    }

    private int[] dfs(TreeNode node) {
        if(node == null) return new int[]{1, 0};


        int[] left = dfs(node.left);
        int[] right = dfs(node.right);

        boolean balanced = (left[0] == 1 && right[0] == 1) && (Math.abs(right[1] - left[1]) <= 1);

        return new int[]{balanced ? 1 : 0, 1 + Math.max(right[1], left[1])};

    }
}