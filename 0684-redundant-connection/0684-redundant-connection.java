class Solution {

    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        int[] parent = new int[n + 1]; // starts from ith node not 0
        int[] rank = new int[n + 1];
        parent = IntStream.rangeClosed(0, n + 1).toArray();

        for (int[] edge : edges) {
            int n1 = edge[0];
            int n2 = edge[1];
            if (!union(parent, rank, n1, n2)) {
                return new int[] { n1, n2 };
            }
        }

        return new int[0];

    }

    private int find(int[] parent, int node) {
        if (node != parent[node]) {
            parent[node] = find(parent, parent[node]);
        }

        return parent[node];
    }

    private boolean union(int[] parent, int[] rank, int n1, int n2) {
        int par1 = find(parent, n1);
        int par2 = find(parent, n2);

        if (par1 == par2)
            return false;

        if (rank[par1] > rank[par2]) {
            parent[par2] = par1;
            rank[par1] += rank[par2];
        } else {
            parent[par1] = par2;
            rank[par2] += rank[par1];
        }
        return true;
    }
}