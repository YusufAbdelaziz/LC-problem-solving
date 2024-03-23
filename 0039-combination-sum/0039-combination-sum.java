class Solution {
    
    LinkedList<List<Integer>> result = new LinkedList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        LinkedList<Integer> track = new LinkedList<>();
        backtrack(candidates, target, 0, track);
        return result;
    }
    
    private void backtrack(int[] candidates, int target, int index, LinkedList<Integer> track) {
//         int sum = track.stream().mapToInt(Integer::intValue).sum();
//         if(sum == target) {
//             result.add(new LinkedList<>(track));
//             return;
//         }
//         else if(sum > target) return;
        
//         for(int i = index; i < candidates.length; i++) {
//             track.add(candidates[i]);
            
//             backtrack(candidates, target, sum < target ? i : i + 1, track);
            
//             track.removeLast();
//         }
        
        if(target == 0) {
            result.add(new LinkedList<>(track));
        } else if(target < 0 || index >= candidates.length) {
            return;
        } else {
           track.add(candidates[index]); 
           
           backtrack(candidates, target - candidates[index], index, track);
            
           track.removeLast();
            
           backtrack(candidates, target, index + 1, track);

        }
    }
}