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
    public int maxDepth(TreeNode root) {
        // DFS solution
        // if(root == null) return 0;
        
        // int countLeft = maxDepth(root.left);
        // int countRight = maxDepth(root.right);
                
        // return Math.max(countLeft, countRight) + 1;
        
        // BFS solution
        
        if(root == null) return 0;
        
        int level = 0;
        
        ArrayDeque<TreeNode> deque = new ArrayDeque<>();
        deque.add(root);
        
        while(!deque.isEmpty()) {
            int size = deque.size();
            for(int i = 0; i < size; i++) {
                TreeNode node = deque.poll();
                if(node.left != null) deque.add(node.left);
                if(node.right != null) deque.add(node.right);
            }
            
            level++;
        }
        
        return level;
    }
}