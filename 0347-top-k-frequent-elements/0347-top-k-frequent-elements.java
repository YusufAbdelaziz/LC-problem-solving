class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // Bucket Sort

        int[] result = new int[k];
        Map<Integer, Integer> occurs = new HashMap<>();

        for (int num : nums) {
            occurs.put(num, occurs.getOrDefault(num, 0) + 1);
        }

        ArrayList<Integer>[] arr = new ArrayList[nums.length];

        for (int i = 0; i < nums.length; i++) {
            arr[i] = new ArrayList<>();
        }

        for (Map.Entry<Integer, Integer> entry : occurs.entrySet()) {
            var curArr = arr[entry.getValue() - 1];
            curArr.add(entry.getKey());
        }

        int j = k - 1;
        for (int i = arr.length - 1; i >= 0 && j  >= 0; i--) {
            var curArr = arr[i];
            if (curArr.size() > 0) {
                for (int e : curArr) {
                    result[j] = e;
                    j--;
                }
            }

        }

        return result;
    }
}