package problems.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzz {
  public List<String> fizzBuzz(int n) {
    List<String> list = new ArrayList<>();

    for (int i = 1; i <= n; i++) {
      StringBuilder strBuilder = new StringBuilder();
      if (i % 3 == 0)
        strBuilder.append("Fizz");
      if (i % 5 == 0)
        strBuilder.append("Buzz");
      else if (i % 5 != 0 && i % 3 != 0) {
        strBuilder.append(i);
      }
      list.add(strBuilder.toString());
    }

    return list;
  }
}
