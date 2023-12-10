class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        
        for(int num : nums) set.add(num);
        
        int longest = 0;
        
        for(int num : set) {
            if(!set.contains(num - 1)) {
                int curLen = 0;
                while(set.contains(num + curLen)) curLen++;
                longest = Math.max(longest, curLen);
            }
        }
        
        return longest;
    }
}
     