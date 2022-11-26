class Solution {
    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, nums.length - k);
    }
    
    private int quickSelect(int[] nums, int left, int right, int k){
        if(left == right) return nums[left];
        
        int pIndex = new Random().nextInt(right - left + 1) + left;
        pIndex = partition(nums, left, right, pIndex);
        
        if(pIndex == k) return nums[k];
        else if(k > pIndex) return quickSelect(nums, pIndex + 1, right, k);
        return quickSelect(nums, left, pIndex - 1, k);
    }
    
    private int partition(int [] nums , int left, int right, int pIndex){
        /// Pivot will be the element at random index pIndex.
        int pivot = nums[pIndex];
        /// The pivot will be then swapped with the rightmost element.
        swap(nums, pIndex, right);
        /// pIndex is then set to the leftmost element in the array (or sub-array).
        pIndex = left;
        
        for(int i = left; i <= right; i++){
            /// If the element at the index i is less than or equal the pivot, then swap
            /// the element at pIndex with the current element and increment pIndex by one
            /// This would result in finding the correct position of the pivot element.
            if(nums[i] <= pivot) {
                swap(nums, i, pIndex);
                pIndex ++;
            }
        }
        
        return pIndex - 1;
    }
    
    private void swap(int [] nums, int x ,int y){
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }
}

    // public int findKthLargest(int[] nums, int k) {
        
        
        
        
        
        /// Largest element -> Min heap.
        /// Whenever you exceed the capacity (k) eject smallest element.
        /// O(nLogK).
//         PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
//         for(int num : nums) {
//             pq.add(num);
//             if(pq.size() > k)
//                 pq.poll();
//         }
        
//         return pq.poll();
    // }