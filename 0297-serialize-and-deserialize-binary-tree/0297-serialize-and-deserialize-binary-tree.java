/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return "null";

        String left = serialize(root.left);
        String right = serialize(root.right);

        return root.val + "," + left + "," + right; 
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] nodes = data.split(",");
        ArrayDeque<String> deque = new ArrayDeque<>(Arrays.asList(nodes));

        return traverse(deque);
    }

    private TreeNode traverse(ArrayDeque<String> stack) {
        String nodeVal = stack.pollFirst();
        if(nodeVal.equals("null")) return null;

        TreeNode newNode = new TreeNode(Integer.parseInt(nodeVal));
        newNode.left = traverse(stack);
        newNode.right = traverse(stack);
        
        return newNode;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));