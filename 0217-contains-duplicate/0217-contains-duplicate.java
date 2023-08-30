class Solution {
    public boolean containsDuplicate(int[] nums) {
        // HashMap -> Time --> O(N), Space --> O(N).
        // Sorting -> Time --> O(NlogN), Space --> Actually it depends upon the algorithm used
        // but in case of using auxillary space it would be O(logN) as recursive algorithms needs
        // O(LogN) space.
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int num : nums){
            int currentCount = map.getOrDefault(num, 0);
            map.put(num, currentCount + 1);
            if(map.get(num) >= 2) {
                return true;
            }
        }
        
        return false;
    }
}