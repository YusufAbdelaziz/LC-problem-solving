class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        var graph = constructGraph(numCourses, prerequisites);
        boolean[] visited = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(i, graph, visited)) {
                return false;
            }
        }
        return true;
    }

    private boolean dfs(int node, Map<Integer, List<Integer>> graph, boolean[] visited) {
        if (visited[node])
            return false;
        visited[node] = true;
        List<Integer> neighbors = graph.get(node);
        for (int neighbor : neighbors) {

            if (!dfs(neighbor, graph, visited)) {
                return false;
            }
        }
        // Basically means this is a good node such that traversal from it
        // won't lead to any cycles, hence we can visit it more than once but we don't need
        // to visit its neighbors again (that's why we removed its neighbors)
        visited[node] = false;
        graph.put(node, new ArrayList<>());
        return true;
    }

    private Map<Integer, List<Integer>> constructGraph(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            graph.put(i, new ArrayList<>());
        }

        for (int[] prerequisite : prerequisites) {
            List<Integer> edges = graph.get(prerequisite[1]);
            edges.add(prerequisite[0]);
        }

        return graph;
    }
}