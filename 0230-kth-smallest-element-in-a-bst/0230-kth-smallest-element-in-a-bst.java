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
    public int kthSmallest(TreeNode root, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        inOrderTraversal(maxHeap, root, k);
        return maxHeap.poll();
    }
    
    private void inOrderTraversal(PriorityQueue<Integer> pq, TreeNode root, int k) {
        if(root == null) return;
        
        inOrderTraversal(pq, root.left, k);
        addNodeToPQ(pq, root, k);
        inOrderTraversal(pq, root.right, k);

    }
    
    private void addNodeToPQ(PriorityQueue<Integer> pq, TreeNode node, int k) {
        pq.offer(node.val);
        
        while(pq.size() > k) pq.poll();
    }
}