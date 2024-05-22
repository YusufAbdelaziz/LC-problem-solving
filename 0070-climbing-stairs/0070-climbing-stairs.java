class Solution {
    public int climbStairs(int n) {
        if(n == 1) return 1;
        
        int s1 = 1, s2 = 2;
        
        for(int i = 3; i <= n; i++) {
            int temp = s2;
            s2 = s1 + s2;
            s1 = temp;
        }
        
        return s2;
    }
}