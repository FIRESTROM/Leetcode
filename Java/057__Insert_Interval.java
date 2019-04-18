class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals.length == 0) {
            int [][] result = new int[1][2];
            result[0] = newInterval;
            return result;
        }
        List<int[]> result_list = new ArrayList<>();
        boolean added = false;
        for (int[] x : intervals) {
            if ((x[0] <= newInterval[0] && x[1] >= newInterval[0]) || (x[0] >= newInterval[0] && newInterval[1] >= x[0])) {
                newInterval[0] = Math.min(newInterval[0], x[0]);
                newInterval[1] = Math.max(newInterval[1], x[1]);
            } else {
                if (!added && newInterval[1] < x[0]) {
                    result_list.add(newInterval);
                    added = true;
                }
                result_list.add(x);
            }
        }
        if (!added) {
            result_list.add(newInterval);
        }
        int[][] result = new int[result_list.size()][2];
        for (int i = 0; i < result_list.size(); i++) {
            result[i] = result_list.get(i);
        }
        return result;
    }
}
