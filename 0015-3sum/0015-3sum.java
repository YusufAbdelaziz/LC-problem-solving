class Solution {
    public  List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> res  = new HashSet<>();
        if(nums.length==0) return new ArrayList<>(res);
        Arrays.sort(nums);
        for(int i=0; i<nums.length-2;i++){
            int j =i+1;
           int  k = nums.length-1;
            while(j<k){
                int sum = nums[i]+nums[j]+nums[k];
                if(sum==0)res.add(Arrays.asList(nums[i],nums[j++],nums[k--]));
                else if (sum >0) k--;
                else if (sum<0) j++;
            }

        }
        return new ArrayList<>(res);

    }

  private static int[] twoSum(int startIndex, int[] nums, int target) {

    int i = startIndex + 1;
    int j = nums.length - 1;
    int len = nums.length;
    while (i != j && i <= len - 1 && j >= 0) {
      int sum = nums[i] + nums[j];
      if (sum == target)
        return new int[] { nums[i], nums[j] };
      if (sum > target) {
        j--;
        if (j > 0 && nums[startIndex] == nums[j])
          j--;
      } else if (sum < target) {
        i++;
        if (i < len - 1 && nums[startIndex] == nums[i])
          i++;
      }
    }

    return new int[] {};
  }
       
}
