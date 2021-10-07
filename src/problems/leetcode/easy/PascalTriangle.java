package src.problems.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

// 118.

public class PascalTriangle {

  public List<List<Integer>> generate(int numRows) {
    ArrayList<List<Integer>> result = new ArrayList<>();

    for (int i = 0; i < numRows; i++) {
      List<Integer> row = new ArrayList<>();

      for (int j = 0; j < i + 1; j++) {
        if (j == 0 || j == i) {
          row.add(1);
        } else {
          List<Integer> aboveRow = result.get(i - 1);
          int a = aboveRow.get(j - 1);
          int b = aboveRow.get(j);
          row.add(a + b);
        }
      }

      result.add(row);
    }
    return result;
  }
}
