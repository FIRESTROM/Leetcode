class Solution {

    private class NewComparator implements Comparator<int[]> {
        @Override
        public int compare(int[] a, int[] b) {
            return a[0] - b[0];
        }
    }

    public boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals, new NewComparator());
        for (int i = 0; i < intervals.length - 1; i++)
            if (intervals[i][1] > intervals[i + 1][0])
                return false;
        return true;
    }
}
