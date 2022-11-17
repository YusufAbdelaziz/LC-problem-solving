class Solution {
    public int findKthLargest(int[] nums, int k) {
        /// O(klogN). Where N is nums.length
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a,b)-> b - a);
        for(int num : nums) pq.add(num);
        
        for(int i = 0 ; i < k - 1 ; i++){
            pq.poll();
        }
        
        return pq.poll();
    }
}