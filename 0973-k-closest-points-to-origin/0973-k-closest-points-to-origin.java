class Solution {

    class Pair<K, V> {
        K k;
        V v;

        Pair(K k, V v) {
            this.k = k;
            this.v = v;
        }

    }

    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Pair<Double, Integer[]>> pq = new PriorityQueue<>((a, b) -> Double.compare(a.k, b.k));

        for (int[] point : points) {
            pq.add(new Pair<Double, Integer[]>(calcEuclideanDistance(point[0], point[1]), new Integer[]{point[0], point[1]}));
        }

        int[][] sol = new int[k][2];

        for (int i = 0; i < k; i++) {
            Pair<Double, Integer[]> p = pq.poll();

            sol[i][0] = p.v[0];
            sol[i][1] = p.v[1];
        }

        return sol;
    }

    // Distance from the origin so (x_2, y_2) are (0, 0).
    private Double calcEuclideanDistance(int x, int y) {
        return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
    }
}