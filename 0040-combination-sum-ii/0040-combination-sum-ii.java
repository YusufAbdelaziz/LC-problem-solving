class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        LinkedList<List<Integer>> res = new LinkedList<>();
        LinkedList<Integer> track = new LinkedList<>();
        
        backtrack(candidates, 0, target, res, track);
        return res;
    }
    
    
    private void backtrack(int[] candidates,  int index, int target, LinkedList<List<Integer>> res, LinkedList<Integer> track) {
        
        if(target == 0) {
            res.add(new LinkedList<>(track));
            return;
        } else if(target < 0) {
            return;
        }
        for(int i = index; i < candidates.length; i++) {
            if(i > index && candidates[i] == candidates[i - 1]) continue;
            
            track.add(candidates[i]);
            
            backtrack(candidates, i + 1, target - candidates[i], res, track);
            
            track.removeLast();
        }
    }
    
}