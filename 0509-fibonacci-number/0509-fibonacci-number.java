class Solution {
    public int fib(int n) {

        if(n == 0) return 0;
        
        int first = 1, second = 1;
        
        for(int i = 3; i <= n; i++) {
            int temp = second;
            second = first + second;
            first = temp;
        }
        
        return second;
    }
}