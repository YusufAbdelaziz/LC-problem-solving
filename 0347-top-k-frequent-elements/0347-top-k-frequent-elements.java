class Solution {
     public int[] topKFrequent(int[] nums, int k) {
      if (nums.length == 0 || nums == null || nums.length == 1)
        return nums;

      HashMap<Integer, Integer> map = new HashMap<>();
      LinkedList<Integer> result = new LinkedList<>();
      for (int num : nums) {
        map.put(num, map.getOrDefault(num, 0) + 1);
      }

      PriorityQueue<Map.Entry<Integer, Integer>> heap = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());

      for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
        heap.add(entry);
      }

      for (int i = 0; i < k; i++) {
        result.add(heap.poll().getKey());
      }

      return result.stream().mapToInt(Integer::intValue).toArray();
    }
}