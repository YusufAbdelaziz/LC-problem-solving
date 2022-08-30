class Solution {
    public boolean containsDuplicate(int[] nums) {
       // Time complexity : O(n)
       // Space Complexity : O(n)
        Set<Integer> hashSet = new HashSet<>();
        
        for(int num : nums){
            if(hashSet.contains(num)) return true;
            hashSet.add(num);
        }
        
        return false;
    }
}