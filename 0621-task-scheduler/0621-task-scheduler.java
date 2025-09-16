class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] count = new int[26];

        for(char task : tasks) {
            count[task - 'A']++;
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for(int c : count) {
            if(c > 0) {
                maxHeap.add(c);
            }
        }
        // [occurrences, time to execute task]
        Queue<int[]> q = new LinkedList<>();

        int time = 0;
        while(!maxHeap.isEmpty() || !q.isEmpty()) {
            time++;

            if(maxHeap.isEmpty()) {
                // jump to the time to execute the task that's at the head of the queue.
                time = q.peek()[1];
            } else {
                int cnt = maxHeap.poll() - 1;

                if(cnt > 0) {
                    q.add(new int[]{cnt, time + n});
                }
            }


            if(!q.isEmpty() && q.peek()[1] == time) {
                maxHeap.add(q.poll()[0]);
            }
        }

        return time;
    }
}