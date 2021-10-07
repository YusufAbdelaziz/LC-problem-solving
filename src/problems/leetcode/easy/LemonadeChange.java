package src.problems.leetcode.easy;

// 860.
public class LemonadeChange {

  public static boolean lemonadeChange(int[] bills) {
    int five = 0, ten = 0;
    int lemonadePrice = 5;

    for (int i = 0; i < bills.length; i++) {
      int change = bills[i] - lemonadePrice;
      if (bills[i] == 5) {
        five++;
      }
      if (bills[i] == 10) {
        ten++;
      }
      if (change != 0) {
        if (change == 5) {
          if (five >= 1)
            five--;
          else
            return false;
        } else if (change == 10) {
          if (ten >= 1) {
            ten--;
          } else if (five >= 2) {
            five -= 2;
          } else
            return false;
        } else if (change == 15) {
          if (ten >= 1 && five >= 1) {
            five--;
            ten--;
          } else if (five >= 3) {
            five -= 3;
          } else
            return false;
        }
      }
    }
    return true;
  }
}
