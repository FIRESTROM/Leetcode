class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int len = gas.length;
        int start = 0;
        int total_tank = 0, curr_tank = 0;
        for (int i = 0; i < len; i++) {
            total_tank += gas[i] - cost[i];
            curr_tank += gas[i] - cost[i];
            if (curr_tank < 0) {
                start = i + 1;
                curr_tank = 0;
            }
        }
        return total_tank >= 0 ? start : -1;
    }
}
