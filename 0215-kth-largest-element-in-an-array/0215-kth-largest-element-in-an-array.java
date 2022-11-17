class Solution {
    public int findKthLargest(int[] nums, int k) {
        /// Largest element -> Min heap.
        /// Whenever you exceed the capacity (k) eject smallest element.
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        for(int num : nums) {
            pq.add(num);
            if(pq.size() > k)
                pq.poll();
        }
        
        return pq.poll();
    }
}