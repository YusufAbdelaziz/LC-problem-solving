class Solution {
    public boolean isHappy(int n) {
        Set<Integer> visit = new HashSet<>();

        while(!visit.contains(n)) {
            visit.add(n);
            n = sumOfSquares(n);
            if(n == 1) return true;
        }


        return false;

    }

    private int sumOfSquares(int n ) {
        int output = 0;

        while(n > 0) {
            int lastDigit = n % 10;
            output += Math.pow(lastDigit, 2);
            n /= 10;
        }

        return output;
    }
}