class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        for(int num : nums){
            maxHeap.add(num);
        }
        
        for(int i = k - 1 ; i > 0 ; i--){
            maxHeap.poll();
        }
        
        return maxHeap.poll();
    }
}