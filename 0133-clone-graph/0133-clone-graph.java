/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    private Map<Node, Node> map = new HashMap<>();

    public Node cloneGraph(Node node) {
        if(node == null) return null;
        if(node.neighbors.size() == 0) return new Node(node.val);

        Node newNode = new Node();
        copy(newNode, node);
        return newNode;
    }

    private void copy(Node copyNode, Node originalNode) {
        
        copyNode.val = originalNode.val;
        map.putIfAbsent(originalNode, copyNode);
        for(Node neighbor : originalNode.neighbors) {
            if(map.getOrDefault(neighbor, null) != null) {
                Node copyNeighbor = map.get(neighbor);
                copyNode.neighbors.add(copyNeighbor);

            } else {
                Node newNeighborCopy = new Node();
                copyNode.neighbors.add(newNeighborCopy);
                copy(newNeighborCopy, neighbor);
            }

            
        }

    }
}
