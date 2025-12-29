class Solution {
    public List<Integer> partitionLabels(String s) {
        Map<Character, Integer> lastOccurrences = new HashMap<>();

        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < s.length(); i++)
            lastOccurrences.put(s.charAt(i), i);

        int end = 0;
        int size = 0;

        for (int i = 0; i < s.length(); i++) {

            end = Math.max(end, lastOccurrences.get(s.charAt(i)));
            size++;

            if (i == end) {
                res.add(size);
                size = 0;
            }
        }

        return res;
    }
}