class Solution {
    private List<List<Integer>> result = new LinkedList<>();
    
    public List<List<Integer>> subsets(int[] nums) {
        LinkedList<Integer> track = new LinkedList<>();
        
        backtrack(nums, 0, track);
        
        return result;
    }
    
    
    private void backtrack(int[] nums, int start, LinkedList<Integer> track) {
        result.add(new LinkedList<>(track));
        for(int i = start; i < nums.length; i++) {
            track.add(nums[i]);
            
            backtrack(nums, i + 1, track);
            
            track.removeLast();
        }
    } 
}