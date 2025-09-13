class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0 || (x % 10 == 0 && x != 0)) return false;

        int halfReversed = 0;

        while( x > halfReversed) {
            int digit = x % 10;
            halfReversed = halfReversed * 10 + digit;
            x /= 10;
        }

        return x == halfReversed || x == halfReversed / 10;
    }
}