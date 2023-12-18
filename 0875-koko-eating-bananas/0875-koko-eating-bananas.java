class Solution {
     public static int minEatingSpeed(int[] piles, int h) {
    int max = Arrays.stream(piles).max().getAsInt();
    int k = max;

    int l = 0;
    int r = max;

    while (l <= r) {
      int mid = l + ((r - l) >>> 1);

      if (calculateHoursSpent(piles, mid) <= h) {
        k = Math.min(k, mid);
        r = mid - 1;
      } else {
        l = mid + 1;
      }
    }
    return k;
  }

  private static int calculateHoursSpent(int[] piles, int k) {
    int sum = 0;
    for (int p : piles) {
      sum += Math.ceil((double) p / k);
    }

    return sum;
  }
}