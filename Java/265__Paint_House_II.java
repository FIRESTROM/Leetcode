class Solution {
    public int minCostII(int[][] costs) {
        int n = costs.length, m = (n == 0) ? 0 : costs[0].length;
        if (n == 0) return 0;
        for (int i = 1; i < n; i++)
            for (int k = 0; k < m; k++)
                costs[i][k] += helper(costs[i - 1], k);
        return helper(costs[n - 1], -1);
    }

    private int helper(int[] A, int avoid) {
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < A.length; i++)
            if (i != avoid)
                result = Math.min(result, A[i]);
        return result;
    }
}
