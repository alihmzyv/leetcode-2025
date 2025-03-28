package blind75.slidingwindow;

public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        int length = prices.length;
        int maxProfit = 0;
        int minBuyPrice = prices[0];
        for (int index = 1; index < length; index++) {
            int currentPrice = prices[index];
            int profit = currentPrice - minBuyPrice;
            if (profit > maxProfit) {
                maxProfit = profit;
            }
            if (currentPrice < minBuyPrice) {
                minBuyPrice = currentPrice;
            }
        }
        return maxProfit;
    }
}
