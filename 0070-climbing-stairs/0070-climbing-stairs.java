class Solution {
    public int climbStairs(int n) {
        /// These two variables represent the last two possible steps.
        int one = 1, two = 1;
        for(int i = n - 2 ; i >= 0; i --){
            int temp = one;
            one += two;
            two = temp;
        }
        
        return one;
    }
}