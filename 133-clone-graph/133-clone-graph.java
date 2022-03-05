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
    public Node cloneGraph(Node node) {
      if(node == null) return null;
      HashMap<Integer, Node> cloneMap = new HashMap<>();
      return cloneGraphByDFS(node, cloneMap);
        
    }
    
    private Node cloneGraphByDFS(Node node, Map<Integer, Node> cloneMap){
        if(cloneMap.containsKey(node.val)) return cloneMap.get(node.val);
        Node copyNode = new Node(node.val);
        cloneMap.put(node.val, copyNode);
        for(Node neighbor : node.neighbors){
            copyNode.neighbors.add(cloneGraphByDFS(neighbor, cloneMap));
        }
        return copyNode;
    }
}

