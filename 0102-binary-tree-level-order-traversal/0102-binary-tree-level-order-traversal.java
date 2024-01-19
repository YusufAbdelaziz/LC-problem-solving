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
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null) return Collections.emptyList();
        
        ArrayDeque<TreeNode> dq = new ArrayDeque<>();
        
        List<List<Integer>> result = new ArrayList<>();
        
        dq.add(root);
        
        while(!dq.isEmpty()) {
            int size = dq.size();
            
            List<Integer> currentLevel = new ArrayList<>();
            for(int i = 0; i < size; i++) {
                TreeNode current = dq.poll();
                
                currentLevel.add(current.val);
                
                if(current.left != null) dq.add(current.left);
                
                if(current.right != null) dq.add(current.right);
            }
            
            result.add(currentLevel);
        }
        
        return result;
    }
}