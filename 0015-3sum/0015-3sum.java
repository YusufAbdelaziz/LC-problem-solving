class Solution {
     public  List<List<Integer>> threeSum(int[] nums) {
         
        if(nums == null || nums.length < 3 ) return Collections.emptyList();
         
        Set<List<Integer>> res  = new HashSet<>();
         
        Arrays.sort(nums);
        if(nums[0] > 1) return Collections.emptyList();
        for(int i = 0; i< nums.length - 2; i++){
           int j = i + 1;
           int k = nums.length - 1;
            while(j < k){
                int sum = nums[i] + nums[j] + nums[k];
                if(sum == 0)res.add(Arrays.asList(nums[i], nums[j++], nums[k--]));
                else if (sum > 0) k--;
                else if (sum < 0) j++;
            }

        }
        return new ArrayList<>(res);

    }
       
}
