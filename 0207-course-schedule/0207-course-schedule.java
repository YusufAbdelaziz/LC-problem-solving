class Solution {
    private enum NodeState {
        VISITIED,
        UNVISITED,
        VISITING
    }
    
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0 ; i < numCourses ; i ++){
            graph.add(new ArrayList<>());
        }
        
        for(int[] prereq : prerequisites) {
            graph.get(prereq[1]).add(prereq[0]);
        }
        
        NodeState[] state = new NodeState[numCourses];
        for(int i = 0 ; i < numCourses ; i ++ ){
            state[i] = NodeState.UNVISITED;
        }
        
        for(int i = 0 ; i < numCourses; i++){
            if(state[i] == NodeState.UNVISITED) {
                if(dfs(i, graph, state)) return false;
            }
        }
        
        return true;
        
    }
    private boolean dfs(int node, List<List<Integer>> graph, NodeState[] state){
        state[node] = NodeState.VISITING;
        boolean hasCycle = false;
        
        for(int neighbour : graph.get(node)){
            if(state[neighbour] == NodeState.UNVISITED) {
                hasCycle |= dfs(neighbour, graph, state);
            } else if(state[neighbour] == NodeState.VISITING){
                hasCycle = true;
            }
            
        }
        state[node] = NodeState.VISITIED;
        
        return hasCycle;
    }
}