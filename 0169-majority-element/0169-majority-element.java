class Solution {
    public int majorityElement(int[] nums) {
        int majorityNum = nums.length / 2;
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int num : nums) {
            int occurrence = map.getOrDefault(num, 0);
            map.put(num, occurrence + 1);
        }
        int majorityElement = 0;
        for (Map.Entry<Integer, Integer> set :
             map.entrySet()) {
            
            if(set.getValue() > majorityNum) majorityElement = set.getKey() ;
        }
        return majorityElement;
    }
}