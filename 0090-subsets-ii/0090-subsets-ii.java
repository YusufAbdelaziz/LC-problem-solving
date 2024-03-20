class Solution {
    List<List<Integer>> res = new LinkedList<>();
    
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        // Sort to eleminate the duplicates while backtracking.
        Arrays.sort(nums);
        LinkedList<Integer> track = new LinkedList<>();
        backtrack(nums, 0, track);
        return res;
    }
    
    private void backtrack(int[] nums, int start, LinkedList<Integer> track) {
        res.add(new LinkedList<>(track));
        
        for(int i = start; i < nums.length; i++) {
            
            if (i > start && nums[i] == nums[i - 1]) continue;
            
            track.add(nums[i]);
            
            backtrack(nums, i + 1, track);
            
            track.removeLast();
        }
    }
}