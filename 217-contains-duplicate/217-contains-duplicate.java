class Solution {
    public boolean containsDuplicate(int[] nums) {
        // O(n) solution with O(n) space.
        Set<Integer> set = new HashSet<>();
        
        for(int num : nums){
            
            if(set.contains(num)){
                return true;
            }
            
            set.add(num);
        }
        
        return false;
    }
}