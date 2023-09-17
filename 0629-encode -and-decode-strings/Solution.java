import java.util.ArrayList;
import java.util.List;

public class Solution {
  public String encode(List<String> list) {
    StringBuilder sb = new StringBuilder();
    for (String str : list) {
      sb.append(str.length() + "#");
      sb.append(str);
    }

    return sb.toString();
  }

  public List<String> decode(String str) {
    List<String> result = new ArrayList<>();
    int len = str.length();

    int i = 0;
    int j = 0;

    while (i < len) {
      int[] pair = scanLength(i, str);
      int start = pair[0];
      int wordLen = pair[1];
      j = start;
      StringBuilder sb = new StringBuilder();
      while (j < start + wordLen) {
        sb.append(str.charAt(j));
        j++;
      }
      result.add(sb.toString());
      i = j;
    }

    return result;
  }

  private int[] scanLength(int start, String str) {
    int i;
    StringBuilder sb = new StringBuilder();

    for (i = start; i < str.length(); i++) {
      char currentChar = str.charAt(i);
      if (currentChar == '#')
        break;
      if (currentChar >= '0' || currentChar <= '9')
        sb.append(currentChar);
    }
    return new int[] { i + 1, Integer.parseInt(sb.toString()) };
  }
}