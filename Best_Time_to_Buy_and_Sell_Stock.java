public class Best_Time_to_Buy_and_Sell_Stock {
    class Solution {
        public int maxProfit(int[] prices) {
            int max = 0;
            int current = prices[0];
            for (int i = 1; i < prices.length; i++) {
                if (current < prices[i]) {
                    if (max < (prices[i] - current)) {
                        max = (prices[i] - current);
                    }
                } else {
                    current = prices[i];
                }
            }
            return max;
        }
    }
}
