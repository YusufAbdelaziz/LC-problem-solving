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
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null) return Collections.emptyList();
        
        List<Integer> result = new ArrayList<>();
        
        // TreeNode cur = root;
        // result.add(cur.val);
        ArrayDeque<TreeNode> dq = new ArrayDeque<>();
        dq.add(root);
        while(!dq.isEmpty()) {
            
            int size = dq.size();
            boolean nodeSeenInLevel = false;
            for(int i = 0; i < size; i++) {
                TreeNode curNode = dq.remove();
                if(curNode.right != null) dq.add(curNode.right);
                if(curNode.left != null) dq.add(curNode.left);
                if(!nodeSeenInLevel) {
                    result.add(curNode.val);
                    nodeSeenInLevel = true;
                }
            }
            
        }
        
        
        return result;
    }
}