class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int result = -1;
        int len = prices.length;
        int[] left = new int[len];
        int[] right = new int[len];
        int cur_min = prices[0], cur_max = prices[len - 1];
        for (int i = 1; i < len; i++) {
            cur_min = Math.min(cur_min, prices[i]);
            left[i] = Math.max(left[i - 1], prices[i] - cur_min);
        }
        for (int i = len - 2; i >= 0; i--) {
            cur_max = Math.max(cur_max, prices[i]);
            right[i] = Math.max(right[i + 1], cur_max - prices[i]);
        }
        for (int i = 0; i < len; i++)
            result = Math.max(result, left[i] + right[i]);
        return result;
    }
}
