class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num : nums){
            if(map.containsKey(num)){
                int occurences = map.get(num);
                map.replace(num, occurences + 1);
            } else {
                map.put(num,1);
            }
        }
        Set<Integer> keys = map.keySet();
        for(Integer key : keys){
            if(map.get(key) > 1) return true;
        }
        return false;
    }
}