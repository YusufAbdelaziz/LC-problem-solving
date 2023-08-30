class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        // Maps an element to its index.
        HashMap<Integer, Integer> map = new HashMap();
        
        for(int i = 0 ; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        
        for(int i = 0 ; i < nums.length; i++) {
            int secondElement = target - nums[i];
            
            Integer secondElementIndex = map.get(secondElement);
            // If second element's index is found and is not the same index
            // as the first element, then return the result
            if(secondElementIndex != null && secondElementIndex != i) {
                result[0] = i;
                result[1] = secondElementIndex;
                return result;
            }
        }
        return result;
    }
}