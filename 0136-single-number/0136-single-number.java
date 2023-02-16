class Solution {
    public int singleNumber(int[] nums) {
       HashSet<Integer> occurrences = new HashSet<>();
       for(int num : nums) {
           if(!occurrences.contains(num)) occurrences.add(num);
           else occurrences.remove(num);
       }
        
       return occurrences.stream().findFirst().get();
    }
}