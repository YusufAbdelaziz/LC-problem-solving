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
    private HashMap<Integer, Integer> inorderPositions = new HashMap<>();
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        
        for(int i = 0; i < inorder.length; i++) inorderPositions.put(inorder[i], i);
        
        return buildHelper(preorder, 0, 0, inorder.length - 1);
    }
    
    private TreeNode buildHelper(int[] preorder, int preorderIndex, int inorderLeft, int inorderRight){
        if(preorderIndex >= preorder.length || inorderLeft > inorderRight) return null;
        
        int currentVal = preorder[preorderIndex];
        TreeNode node = new TreeNode(currentVal);
        int midIndex = inorderPositions.get(currentVal);
        
        node.left = buildHelper(preorder, preorderIndex + 1, inorderLeft, midIndex - 1);
        node.right = buildHelper(preorder, preorderIndex + (midIndex - inorderLeft) + 1, midIndex + 1,                                              inorderRight);
        
        return node;
        
    }
}