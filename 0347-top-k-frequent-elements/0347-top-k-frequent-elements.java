class Solution {
     public int[] topKFrequent(int[] nums, int k) {
      if (nums.length == 0 || nums == null || nums.length == 1)
        return nums;
      // Time -> O(K log n) where K is the number of pops we make for the max heap.
      // Space -> O(N) where N is the number of pairs that store the number and its
      // repetitions.
      // HashMap<Integer, Integer> map = new HashMap<>();
      // LinkedList<Integer> result = new LinkedList<>();
      // for (int num : nums) {
      // map.put(num, map.getOrDefault(num, 0) + 1);
      // }

      // PriorityQueue<Map.Entry<Integer, Integer>> heap = new PriorityQueue<>((a, b)
      // -> b.getValue() - a.getValue());

      // for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
      // heap.add(entry);
      // }

      // for (int i = 0; i < k; i++) {
      // result.add(heap.poll().getKey());
      // }

      // return result.stream().mapToInt(Integer::intValue).toArray();

      HashMap<Integer, Integer> map = new HashMap<>();
      int[] result = new int[k];
      for (int num : nums) {
        map.put(num, map.getOrDefault(num, 0) + 1);
      }

      ArrayList<Integer>[] count = new ArrayList[nums.length];
      for (int i = 0; i < count.length; i++) {
        count[i] = new ArrayList<Integer>();
      }

      for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
        var valuesArr = count[entry.getValue() - 1];
        valuesArr.add(entry.getKey());
      }

      int j = k - 1;

      for (int i = count.length - 1; i >= 0 && j >= 0; i--) {
        if (count[i].size() > 0) {
          for (int num : count[i]) {
            result[j] = num;
            j--;
          }
        }
      }

      return result;
    }
}