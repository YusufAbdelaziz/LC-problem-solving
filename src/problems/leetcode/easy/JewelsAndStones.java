package problems.leetcode.easy;

public class JewelsAndStones {
  public int numJewelsInStones(String jewels, String stones) {
    if (jewels == null || stones == null)
      throw new IllegalArgumentException("Arguments are null");
    int jewelsLength = jewels.length();
    int stonesLength = stones.length();
    if (jewelsLength == 0 || stonesLength == 0)
      return 0;
    int jewelsInStones = 0;
    for (int i = 0; i < stonesLength; i++) {
      char stone = stones.charAt(i);
      if (jewels.contains(Character.toString(stone)))
        jewelsInStones++;
    }

    return jewelsInStones;
  }
}
