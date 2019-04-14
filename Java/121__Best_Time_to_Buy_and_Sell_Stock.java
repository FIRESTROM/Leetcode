class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int result = 0;
        int min_price = prices[0];
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < min_price) {
                min_price = prices[i];
            } else if (prices[i] - min_price > result) {
                result = prices[i] - min_price;
            }
        }
        return result;
    }
}
