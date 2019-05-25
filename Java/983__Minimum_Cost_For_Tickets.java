class Solution {
    int[] days, costs;
    Integer[] memo;
    int[] durations = new int[]{1, 7, 30};

    public int mincostTickets(int[] days, int[] costs) {
        this.days = days;
        this.costs = costs;
        memo = new Integer[days.length];
        return helper(0);
    }

    public int helper(int i) {
        if (i >= days.length)
            return 0;
        if (memo[i] != null)
            return memo[i];
        int result = Integer.MAX_VALUE;
        int j = i;
        for (int k = 0; k < 3; k++) {
            while (j < days.length && days[j] < days[i] + durations[k]) j++;
            result = Math.min(result, helper(j) + costs[k]);
        }
        memo[i] = result;
        return result;
    }
}
