class Solution {
    public int coinChange(int[] coins, int amount) {
        if(amount == 0) return 0;

        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;

        for(int currentAmount = 1; currentAmount < dp.length; currentAmount++) {
            for(int coin : coins) {
                // calculate the difference between current amount to be found and
                // the current coin.
                if(currentAmount - coin >= 0) {
                    dp[currentAmount] = Math.min(dp[currentAmount], 1 + dp[currentAmount - coin]);
                }
            }
        }
        return dp[amount] == amount + 1 ? -1 : dp[amount];

        // Time Complexity -> O(amount * coins)
        // Space Complexity -> O(amount)
    }
}