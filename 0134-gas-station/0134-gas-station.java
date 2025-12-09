class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        
        int costSum =  Arrays.stream(cost).sum();

        int gasSum =  Arrays.stream(gas).sum();

        if(gasSum < costSum) return -1;

        int res = 0;
        int total = 0;

        for(int i = 0; i < gas.length; i++) {
            total += gas[i] - cost[i];
            
            if(total < 0) {
                total = 0;
                res = i + 1;
            }
        }

        return res;

    }
}