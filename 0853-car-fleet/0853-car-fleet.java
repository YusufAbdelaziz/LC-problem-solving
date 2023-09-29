class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        if(position.length == 1) return 1;
        int len = position.length;
        int res = 0;
        double[][] cars = new double[len][2];
        for(int i = 0; i < len; i++) {
            cars[i] = new double[] {position[i], (double) (target - position[i]) / speed[i]};
        }
        // Sort by position in ascending order.
        Arrays.sort(cars, (a, b) -> Double.compare(a[0], b[0]));
        
        // Stores biggest time (slowest car).
        double cur = 0;
        for(int i = len - 1; i >= 0; i--) {
            if(cars[i][1] > cur) {
                cur = cars[i][1];
                res++;
            }
        }
        
        return res;
    }
}