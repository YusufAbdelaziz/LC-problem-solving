class Solution {
    public int climbStairs(int n) {
        /// These two variables represent the last two possible steps.
        int one = 1, two = 0;
        for(int i = n - 1 ; i >= 0; i --){
            int temp = one;
            one += two;
            two = temp;
        }
        
        return one;
    }
}