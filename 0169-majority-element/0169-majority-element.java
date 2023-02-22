class Solution {
    public int majorityElement(int[] nums) {
//         int majorityNum = nums.length / 2;
        
//         HashMap<Integer, Integer> map = new HashMap<>();
        
//         for(int num : nums) {
//             int occurrence = map.getOrDefault(num, 0);
//             map.put(num, occurrence + 1);
//         }
//         int majorityElement = 0;
//         for (Map.Entry<Integer, Integer> set :
//              map.entrySet()) {
            
//             if(set.getValue() > majorityNum) majorityElement = set.getKey() ;
//         }
//         return majorityElement;
        
        int candidate = 0;
        int count = 0;
        
        for(int num : nums){
            if(count == 0) candidate = num;
            if(candidate == num) count += 1;    
            else count -= 1;
        }
        
        return candidate;
    }
}