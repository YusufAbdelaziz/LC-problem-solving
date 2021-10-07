package src.problems.leetcode.easy;

// 121
public class BestTimeToBuyAndSellStock {

  public int maxProfit(int[] prices) {
    int maxProfit = 0;
    // One pointer to determine on which day to buy a stock.
    int buy = 0;
    // Another pointer to determine on which day to sell a stock.
    int sell = 1;
    while (sell < prices.length) {
      // If selling price is less than buy price, then buy at that day.
      if (prices[sell] < prices[buy]) {
        buy = sell;
      }
      // If the subtraction of the price of the stock at selling day and buying day is
      // bigger than current [maxProfit], then update the [maxProfit].
      if (prices[sell] - prices[buy] > maxProfit) {
        maxProfit = prices[sell] - prices[buy];
      }
      // Update [sell] to keep looking for an appropriate day to sell the stock on.
      sell++;
    }

    return maxProfit;
  }

}
