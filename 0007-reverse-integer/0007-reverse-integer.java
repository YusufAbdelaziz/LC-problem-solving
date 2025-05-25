class Solution {
    public int reverse(int x) {
      // final int MIN = -2147483648; // -2^31
      // final int MAX = 2147483647;  // 2^31 - 1
      int max = Integer.MAX_VALUE, min = Integer.MIN_VALUE;
      if(x == max || x == min) return 0;

    
      int res = 0;

      while(x != 0) {
        int digit = x % 10;
        x /= 10;

        // Note that max % 10 is 7 
        if(res > max / 10 || (res == max / 10 && digit > max % 10)) {
            return 0;
        }

         if(res < min / 10 || (res == min / 10 && digit < min % 10)) {
            return 0;
        }


        res = (res * 10) + digit;
      }

      return res;
    }
}