class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

        for(int stone : stones) {
            pq.add(stone);
        }

        while(!pq.isEmpty() && pq.size() > 1) {
            int x = pq.poll();
            int y = pq.poll();

            if(x != y) pq.add(x - y);

            if(pq.isEmpty()) pq.add(0);
        }


        return pq.poll();
    }
}