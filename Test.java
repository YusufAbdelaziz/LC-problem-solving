public class Test {

  public static String shift(String s, int k) {
    StringBuilder sb = new StringBuilder(s);
    for (int i = 0; i < s.length(); i++) {
      int index = (i + k) % s.length();
      sb.setCharAt(index, s.charAt(i));
    }
    return sb.toString();
  }

  public static void main(String[] args) {
    String unshifted = "Testing";
    System.out.println(shift(unshifted, 2));
  }

}
