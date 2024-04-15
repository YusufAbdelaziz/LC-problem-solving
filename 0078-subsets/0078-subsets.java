class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        LinkedList<Integer> track = new LinkedList<>();
        List<List<Integer>> result = new LinkedList<>();
        backtrack(nums, 0, track, result);
        return result;
    }
    
    
    public void backtrack(int[] nums, int index, LinkedList<Integer> track, List<List<Integer>> result) {
        if(!result.contains(track)) {
            result.add(new LinkedList<>(track));
        }
        
        for(int i = index; i < nums.length; i++) {
            track.add(nums[i]);
            
            backtrack(nums, i + 1, track, result);
            
            track.removeLast();
        }
    }
}