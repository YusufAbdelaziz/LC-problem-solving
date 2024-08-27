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
    public int rob(TreeNode root) {
        int[] res = dp(root);

        return Math.max(res[0], res[1]);
    }

    // arr[0] -> current node result is not robbed
    // arr[1] -> current node result is robbed
    private int[] dp(TreeNode root) {
        if(root == null) return new int[]{0, 0};

        int[] left = dp(root.left);
        int[] right = dp(root.right);

        // If you decide to rob the current node, then you have to choose the skipped
        // left and right value (index 0)?
        int rob = root.val + left[0] + right[0];

        // If you decide not to rob the current node, you are free to choose
        // between robbing the left node of skipping it and the same right node follos
        // the same concept.
        int noRob = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);

        return new int[]{noRob, rob};
    }
}