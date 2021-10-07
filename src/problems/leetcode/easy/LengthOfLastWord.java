package src.problems.leetcode.easy;

public class LengthOfLastWord {
  public int lengthOfLastWord(String s) {
    if (s == null)
      return 0;

    String newS = s.trim();
    StringBuilder strB = new StringBuilder();
    for (int i = newS.length() - 1; i >= 0; i--) {
      if (newS.charAt(i) != ' ') {
        strB.append(newS.charAt(i));
      } else {
        break;
      }
    }

    return strB.toString().length();
  }
}