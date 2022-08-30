class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        var sol = new int[2];
        for(int i = 0 ; i < nums.length ; i++){
            int diff = target - nums[i];
           if(map.containsKey(diff)){
               sol[0] = i;
               sol[1] = map.get(diff);
               return arr;
           }
          map.put(nums[i], i);
       }
        return sol;
    }
}
