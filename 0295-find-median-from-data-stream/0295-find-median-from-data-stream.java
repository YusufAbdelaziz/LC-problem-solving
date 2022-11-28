class MedianFinder {
    /// Stores small numbers.
    private PriorityQueue<Integer> maxHeap;

    /// Stores large numbers.
    private PriorityQueue<Integer> minHeap;
    
    public MedianFinder() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    }
    
    public void addNum(int num) {
        /// By default, add the num to maxHeap.
        maxHeap.offer(num);
        /// Get the maximum of the maxHeap and give it to minHeap (stores large numbers).
        minHeap.offer(maxHeap.poll());
        /// If the minHeap has more items than maxHeap, then throw the minimum element in the
        /// minHeap and pass it to the maxHeap.
        if(minHeap.size() > maxHeap.size()){
            maxHeap.offer(minHeap.poll());
        }
    }
    
    public double findMedian() {
        if(maxHeap.size() > minHeap.size()){
            /// We only need to take a look at the maximum item so don't use "poll" as it
            /// costs O(logN).
            return maxHeap.peek();
        }
        return (minHeap.peek() + maxHeap.peek()) / 2.0d;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */