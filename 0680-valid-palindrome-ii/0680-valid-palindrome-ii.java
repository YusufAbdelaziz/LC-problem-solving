class Solution {
    public boolean validPalindrome(String s) {
        int len = s.length();

        int i = 0, j = len - 1;

        boolean characterDeleted = false;

        while (i <= j) {
            char currentI = s.charAt(i);
            char currentJ = s.charAt(j);
            if (currentI != currentJ) {
                // let's peek and see which one to skip.
                return isPalindrome(s, i + 1, j) ||
                        isPalindrome(s, i, j - 1);
            } else {
                i++;
                j--;
            }

        }

        return true;
    }

    private boolean isPalindrome(String s, int i , int j) {

        while(i < j) {
            if( s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }

        return true;
    }
}