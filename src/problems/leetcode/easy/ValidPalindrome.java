package problems.leetcode.easy;

public class ValidPalindrome {
  public boolean isPalindrome(String s) {
    if (s == null)
      throw new IllegalArgumentException("The string is null");

    int l = 0;
    int r = s.length() - 1;
    while (l < r) {
      char rightChar = Character.toLowerCase(s.charAt(r));
      char leftChar = Character.toLowerCase(s.charAt(l));
      if (isAlphaNumeric(rightChar) && isAlphaNumeric(leftChar)) {
        if (rightChar != leftChar)
          return false;
        l++;
        r--;
      } else if (isAlphaNumeric(rightChar)) {
        l++;
      } else if (isAlphaNumeric(leftChar)) {
        r--;
      } else {
        l++;
        r--;
      }

    }
    return true;
  }

  public boolean isAlphaNumeric(char s) {
    return (s >= 'a' && s <= 'z' || s >= '0' && s <= '9');
  }

}
