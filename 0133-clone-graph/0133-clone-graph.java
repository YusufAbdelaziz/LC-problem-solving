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
        if(node == null) return node;
        else if(node.neighbors.isEmpty()) return new Node(node.val);
        
        HashMap<Integer, Set<Integer>> map = new HashMap<>();
        boolean[] visited = new boolean[101];
        
        // Construct the map.
        dfs(node, visited, map);
        
        HashMap<Integer, Node> copyMap = new HashMap<>();
        
        // Create copy nodes.
        for(int nodeVal : map.keySet()) {           
              copyMap.put(nodeVal, new Node(nodeVal));      
        }
        
        // Create connections.
        for(int nodeVal : map.keySet()) {
              Node copiedNode = copyMap.get(nodeVal);
              Set<Integer> neighbors = map.get(nodeVal);
                
              for(int neighbor : neighbors) {
                  Node neighborNode = copyMap.get(neighbor);
                  copiedNode.neighbors.add(neighborNode);
              }
        }
            
        return copyMap.get(node.val);
        
    }
    
    
    private void dfs(Node node, boolean[] visited, HashMap<Integer, Set<Integer>> map) {
        Set<Integer> neighbors = map.getOrDefault(node.val, new HashSet<>());
        if(neighbors.isEmpty()) {
            map.put(node.val, neighbors);
        }
        visited[node.val] = true;
        
        for(Node neighbor : node.neighbors) {
            neighbors.add(neighbor.val);
            if(!visited[neighbor.val]) {
                dfs(neighbor, visited, map);
            }
        }
        
    }
}