class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0) return false;

        int og = x;
        int reversed = 0;

        while(og != 0) {
            int digit = og % 10;
            reversed = reversed * 10 + digit;
            og /= 10;
        }

        return x == reversed;
    }
}