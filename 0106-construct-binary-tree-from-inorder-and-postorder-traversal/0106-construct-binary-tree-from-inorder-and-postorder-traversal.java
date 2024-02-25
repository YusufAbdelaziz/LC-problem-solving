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
    HashMap<Integer, Integer> inOrderPositions = new HashMap<>();
    
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for(int i = 0; i < inorder.length; i++) inOrderPositions.put(inorder[i], i);
        
        return buildTreeHelper(postorder, postorder.length - 1, 0, inorder.length - 1);
    }
    
    private TreeNode buildTreeHelper(int[] postorder, int postorderIndex, int inorderLow, int inorderHigh){
        if(postorderIndex < 0 || inorderLow > inorderHigh) return null;
        
        
        int currentValue = postorder[postorderIndex];
        
        int midIndex = inOrderPositions.get(currentValue);
        
        TreeNode node = new TreeNode(currentValue);
        
        node.right = buildTreeHelper(postorder, postorderIndex - 1, midIndex + 1, inorderHigh);
        node.left = buildTreeHelper(postorder, postorderIndex - (inorderHigh - midIndex) - 1, inorderLow, midIndex - 1 );
        
        return node;
    }
}