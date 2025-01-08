class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        int[] order = new int[numCourses];
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] p : prerequisites) {
            adj.get(p[1]).add(p[0]);
            indegree[p[0]]++;
        }

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }
        int index = 0;

        while (!q.isEmpty()) {
            int node = q.poll();
            order[index++] = node;
            List<Integer> neighbors = adj.get(node);
            for (int neighbor : neighbors) {
                indegree[neighbor]--;
                if(indegree[neighbor] == 0) {
                    q.offer(neighbor);
                }
            }

        }

        if(index != numCourses) {
            return new int[]{};
        }

        return order;
    }
}