class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            var numIndexOrList = map.get(nums[i]);
            map.put(nums[i], i);
            
             
        } 
        
        int[] sol = new int[2];
        
        for(int i = 0 ; i < nums.length ; i ++){
            var secondNum = target - nums[i];
            var secondNumIndex = map.get(secondNum);
            if(secondNumIndex != null && secondNumIndex != i){
                sol[0] = i;
                sol[1] = secondNumIndex;
                break;
            }
        }
        
        return sol;
    }
}